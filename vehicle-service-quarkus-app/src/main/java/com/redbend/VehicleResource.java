package com.redbend;

import com.redbend.model.Ecu;
import com.redbend.model.Vehicle;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleService vehicleService;

    @GET
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GET
    @Path("/{id}")

    public Vehicle getVehicle(@PathParam("id") Long id) {
        return vehicleService.getVehicle(id);
    }

    @GET
    @Path("/{id}/ecu")
    public Response getEcuFoVehicle(@PathParam("id") Long vehicleId) {
        List<Ecu> ecus = vehicleService.getEcuForVehicle(vehicleId);

        return Response.accepted()
                .entity(ecus)
                .build();
    }
}