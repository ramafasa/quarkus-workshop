package com.redbend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbend.model.Vehicle;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VehicleResourceTest {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void shouldReturnRetrievedVehicle() throws JsonProcessingException {

        Vehicle vehicle = new Vehicle();
        vehicle.setModel("model");

        given()
                .when().get("/vehicles/1")
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(vehicle)));
    }
}