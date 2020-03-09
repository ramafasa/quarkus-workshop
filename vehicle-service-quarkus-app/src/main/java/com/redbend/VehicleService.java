package com.redbend;


import com.redbend.model.Ecu;
import com.redbend.model.Vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VehicleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

    public List<Vehicle> getVehicles() {
        LOGGER.debug("Retrieving all vehicles");
        return Vehicle.listAll();
    }

    public Vehicle getVehicle(Long id) {
        LOGGER.debug("Retrieving vehicle with id {}", id);
        return Vehicle.findById(id);
    }

    public List<Ecu> getEcuForVehicle(Long vehicleId) {
        LOGGER.debug("Retrieving ECUs for vehicle with id {}", vehicleId);
        return ((Vehicle) Vehicle.findById(vehicleId)).getEcuList();
    }
}
