package com.demo.server.update

import com.demo.server.*
import com.demo.server.software.Software
import com.demo.server.software.SoftwareRepository
import com.demo.server.vehicle.Vehicle
import com.demo.server.vehicle.VehicleRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class UpdateService(private val softwareRepository: SoftwareRepository,
                    private val vehicleRepository: VehicleRepository) {


    fun getVehicleUpdates(updateRequests: Set<UpdateRequest>): List<AvailableUpdate> {
        val supportedVehicles = vehicleRepository.findAll()
        val supportedSoftware = softwareRepository.findAll().toList()

        val availableVehicleUpdates: MutableList<AvailableUpdate> = mutableListOf()
        for (updateRequest in updateRequests) {
            supportedVehicles.find { updateRequest.vehicleId == it.id }?.let {
                val availableEcuUpdates = getAvailableUpdates(it, updateRequest.ecus, supportedSoftware)
                logger.debug { "Software updates are available for vehicle ${it.id}: $availableEcuUpdates" }
                availableVehicleUpdates.add(AvailableUpdate(vehicleId = it.id, ecu = availableEcuUpdates))
            }
        }
        return availableVehicleUpdates;
    }



    fun getAvailableUpdates(vehicle: Vehicle, ecus: Set<EcuRequest>, supportedSoftware: List<Software>): List<AvailableEcuUpdate> {
        val availableSoftwareUpdates = ecus.flatMap { it.software }.mapNotNull { supportedSoftware.find { sw -> it.id == sw.id && sw.version > it.version } }

        if (availableSoftwareUpdates.isEmpty()) {
            logger.debug { "No software updates are available for given ECUs: $ecus" }
            return emptyList()
        }

        val clientEcuUpdates = mutableListOf<AvailableEcuUpdate>()
        for (ecu in ecus) {
            val isEcuSupported = vehicle.ecus.any { it.id == ecu.id }
            if (!isEcuSupported) {
                logger.debug { "One of the ECUs in vehice ${vehicle.id} is not managed by the server." }
                continue
            }
            for (softwareRequest in ecu.software) {
                val softwareWithUpdate = availableSoftwareUpdates.find { it.id == softwareRequest.id && it.supportedEcus.any { supportedEcu -> supportedEcu.id == ecu.id} }

                softwareWithUpdate?.let {
                    val availableSoftwareUpdate = AvailableSoftwareUpdate(id = it.id, version = it.version)
                    val aeu = clientEcuUpdates.find { ecu.id == it.id }
                    aeu?.availableSoftwareUpdate?.add(availableSoftwareUpdate)
                            ?: clientEcuUpdates.add(AvailableEcuUpdate(id = ecu.id, availableSoftwareUpdate = mutableListOf(availableSoftwareUpdate)))
                }

            }
        }
        return clientEcuUpdates
    }



}