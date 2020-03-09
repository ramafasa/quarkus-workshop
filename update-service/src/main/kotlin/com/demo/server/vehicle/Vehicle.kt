package com.demo.server.vehicle

import com.demo.server.common.AbstractJpaPersistable
import com.demo.server.ecu.Ecu
import java.math.BigInteger
import javax.persistence.*

@Entity
@Table(name = "vehicle")
class Vehicle(@field:ManyToMany
              @field: JoinTable(name = "vehicle_ecu",
                      joinColumns = arrayOf(JoinColumn(name = "vehicle_id")),
                      inverseJoinColumns = arrayOf((JoinColumn(name = "ecu_id")))
              )
              var ecus: List<Ecu>) : AbstractJpaPersistable<BigInteger>()