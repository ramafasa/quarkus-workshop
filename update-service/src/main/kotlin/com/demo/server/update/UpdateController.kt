package com.demo.server.update

import com.demo.server.AvailableUpdate
import com.demo.server.UpdateRequest
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/updates")
class UpdateController(private val updateService: UpdateService) {

    @PostMapping("/")
    fun getUpdates(@RequestBody updateRequest: Set<UpdateRequest>): List<AvailableUpdate> {
        logger.debug { "Received a request with the content: $updateRequest" }
        return updateService.getVehicleUpdates(updateRequest)
    }
}