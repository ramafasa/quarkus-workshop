package com.demo.server.software

import org.springframework.data.repository.CrudRepository
import java.math.BigInteger

interface SoftwareRepository: CrudRepository<Software, BigInteger>