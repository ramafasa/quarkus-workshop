package com.demo.server.vehicle

import org.springframework.data.repository.CrudRepository
import java.math.BigInteger

interface VehicleRepository: CrudRepository<Vehicle, BigInteger>