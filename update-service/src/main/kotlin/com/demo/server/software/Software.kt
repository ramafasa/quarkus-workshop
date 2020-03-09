package com.demo.server.software

import com.demo.server.ecu.Ecu
import com.demo.server.common.AbstractJpaPersistable
import java.math.BigInteger
import javax.persistence.*

@Entity
@Table(name = "software")
class Software(var name: String,
               var version: Long,
               @field:ManyToMany
               @field: JoinTable(name = "software_ecu",
                       joinColumns = arrayOf(JoinColumn(name = "software_id")),
                       inverseJoinColumns = arrayOf((JoinColumn(name = "ecu_id")))
               )
               var supportedEcus: List<Ecu>) : AbstractJpaPersistable<BigInteger>()