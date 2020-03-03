package com.redbend;

import com.redbend.model.Vehicle;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vehicles")
public class VehicleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getVehicles() {
        return Vehicle.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getVehicle(@PathParam("id") Long id) {
        return Vehicle.findById(id);
    }
}