package com.awsspringboot.service;

import com.awsspringboot.model.Vehicle;
import com.awsspringboot.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleServiceImplementation implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
