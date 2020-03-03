package com.redbend.repository;

import com.redbend.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import java.math.BigInteger;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
