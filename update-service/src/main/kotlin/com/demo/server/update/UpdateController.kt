package com.demo.server.update

import com.demo.server.AvailableUpdate
import com.demo.server.UpdateRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/updates")
class UpdateController(private val updateService: UpdateService) {

    @PostMapping("/")
    fun getUpdates(@RequestBody updateRequest: UpdateRequest): List<AvailableUpdate> {
        return updateService.getVehicleUpdates(listOf(updateRequest))
    }
}