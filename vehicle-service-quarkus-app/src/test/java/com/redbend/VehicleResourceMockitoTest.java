package com.redbend;

import com.redbend.model.Vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@QuarkusTest
public class VehicleResourceMockitoTest {

    @Mock
    private VehicleService vehicleService;


    @InjectMocks
    private VehicleResource sut = new VehicleResource();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnRetrievedVehicle() {
        // given
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Toyota");

        given(vehicleService.getVehicles()).willReturn(List.of(vehicle));

        // when
        List<Vehicle> actual = sut.getVehicles();

        // then
        assertEquals(List.of(vehicle), actual);
    }
}