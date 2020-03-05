package com.demo.server.ecu

import com.demo.server.common.AbstractJpaPersistable
import com.demo.server.software.Software
import com.demo.server.vehicle.Vehicle
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "ecu")
class Ecu(@field:ManyToMany(mappedBy = "supportedEcus")
          var software: List<Software>,
          @field:ManyToMany(mappedBy = "ecus")
          var vehicles: List<Vehicle>) : AbstractJpaPersistable<BigInteger>()