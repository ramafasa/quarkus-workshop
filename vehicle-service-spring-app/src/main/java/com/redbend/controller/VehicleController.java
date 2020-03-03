package com.redbend.controller;

import com.redbend.model.Vehicle;
import com.redbend.repository.VehicleRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/vehicles")
public class VehicleController {

    private  VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable("id") Long id) {
        return vehicleRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle with id " + id + " not found."));
    }
}
