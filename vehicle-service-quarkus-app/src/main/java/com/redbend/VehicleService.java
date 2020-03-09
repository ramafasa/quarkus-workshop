package com.redbend;


import com.redbend.model.Ecu;
import com.redbend.model.Vehicle;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VehicleService {

    public List<Vehicle> getVehicles() {
        return Vehicle.listAll();
    }

    public Vehicle getVehicle(Long id) {
        return Vehicle.findById(id);
    }

    public List<Ecu> getEcuForVehicle(Long vehicleId) {
        return ((Vehicle) Vehicle.findById(vehicleId)).getEcuList();
    }
}
