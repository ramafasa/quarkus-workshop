package com.demo.server

import com.demo.server.ecu.Ecu
import com.demo.server.software.Software
import com.demo.server.software.SoftwareRepository
import com.demo.server.update.UpdateService
import com.demo.server.vehicle.Vehicle
import com.demo.server.vehicle.VehicleRepository
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigInteger

@ExtendWith(MockKExtension::class)
class UpdateServiceTest {

    @MockK
    lateinit var softwareRepository: SoftwareRepository

    @MockK
    lateinit var vehicleRepository: VehicleRepository

    @InjectMockKs
    lateinit var sut: UpdateService

    @Test
    fun `getAvailableUpdates should return available updates for vehicle and ecu which are supported by the backend`() {
        // GIVEN
        val supportedEcu = createEcu(BigInteger.ONE)
        val vehicle = createVehicle(BigInteger.ONE, supportedEcu)

        val supportedSoftware = createSupportedSoftware(BigInteger.ONE, "powertrain", 2, supportedEcu)

        val softwareRequest = SoftwareRequest(BigInteger.valueOf(1), name= "powertrain", version = 1)
        val ecuRequest = EcuRequest(id = BigInteger.valueOf(1), software = listOf(softwareRequest))

        // WHEN
        val actual = sut.getAvailableUpdates(vehicle, listOf(ecuRequest), listOf(supportedSoftware))

        // THEN
        assertThat(actual)
                .isNotNull
                .isNotEmpty
                .hasSize(1)
    }

    @Test
    fun `getAvailableUpdates should not return updates for software which is already up-to-date`() {
        val supportedEcu = createEcu(BigInteger.ONE)
        val vehicle = createVehicle(BigInteger.ONE, supportedEcu)

        val supportedSoftware = createSupportedSoftware(BigInteger.ONE, "powertrain", 2, supportedEcu)

        val softwareRequest = SoftwareRequest(BigInteger.valueOf(1), name= "powertrain", version = 2)
        val ecuRequest = EcuRequest(id = BigInteger.valueOf(1), software = listOf(softwareRequest))

        // WHEN
        val actual = sut.getAvailableUpdates(vehicle, listOf(ecuRequest), listOf(supportedSoftware))

        // THEN
        assertThat(actual).isNullOrEmpty()

    }

    @Test
    fun `getAvailableUpdates should not return updates if the ecu is not managed by the server`() {
        val supportedEcu = createEcu(BigInteger.ONE)
        val vehicle = createVehicle(BigInteger.ONE, supportedEcu)

        val supportedSoftware = createSupportedSoftware(BigInteger.ONE, "powertrain", 2, supportedEcu)

        val softwareRequest = SoftwareRequest(BigInteger.valueOf(1), name= "powertrain", version = 2)
        val ecuRequest = EcuRequest(id = BigInteger.valueOf(2), software = listOf(softwareRequest))

        // WHEN
        val actual = sut.getAvailableUpdates(vehicle, listOf(ecuRequest), listOf(supportedSoftware))

        // THEN
        assertThat(actual).isNullOrEmpty()

    }

    private fun createVehicle(id: BigInteger, ecu: Ecu): Vehicle {
        val vehicle = Vehicle(listOf(ecu))
        vehicle.id = id
        return vehicle
    }

    private fun createSupportedSoftware(swId: BigInteger, swName: String, swVersion: Long, ecu: Ecu): Software {
        val supportedSoftware = Software(name = swName, version = swVersion, supportedEcus = listOf(ecu))
        supportedSoftware.id = swId
        return supportedSoftware
    }

    private fun createEcu(ecuId: BigInteger): Ecu {
        val supportedEcu = Ecu(emptyList(), emptyList())
        supportedEcu.id = ecuId
        return supportedEcu
    }
}