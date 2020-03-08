package com.demo.server

import java.math.BigInteger

data class UpdateRequest(var vehicleId: BigInteger?,
                         var ecus: Set<EcuRequest>)


data class EcuRequest(val id: BigInteger,
               val software: Set<SoftwareRequest>)

data class SoftwareRequest(val id: BigInteger,
                    val name: String,
                    val version: Long)


data class AvailableUpdate(val vehicleId: BigInteger?,
                           val ecu: List<AvailableEcuUpdate>)

data class AvailableEcuUpdate(val id: BigInteger,
                              val availableSoftwareUpdate: MutableList<AvailableSoftwareUpdate>)

data class AvailableSoftwareUpdate(val id: BigInteger?,
                                   val version: Long)