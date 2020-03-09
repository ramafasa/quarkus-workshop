package com.redbend.mock;

import com.redbend.VehicleService;
import com.redbend.model.Vehicle;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;


@Alternative
@Priority(1)
@ApplicationScoped
public class VehicleServiceMock extends VehicleService {

    @Override
    public Vehicle getVehicle(Long id) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("model");
        return vehicle;
    }
}
