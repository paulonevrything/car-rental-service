package com.awsspringboot.service;

import com.awsspringboot.model.Status;
import com.awsspringboot.model.Vehicle;
import com.awsspringboot.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleServiceImplementation implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicle.setId(UUID.randomUUID().toString());
        vehicle.setStatus(Status.AVAILABLE);
        vehicle.setOwner(null);
        vehicle.setAssociationDate(null);

        return vehicleRepository.save(vehicle);
    }
}
