package com.awsspringboot.service;

import com.awsspringboot.model.Status;
import com.awsspringboot.model.Vehicle;
import com.awsspringboot.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    @Override
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(String vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow();
    }

    @Override
    public void associate(String vehicleId, String userId) {
        var vehicle = vehicleRepository.findById(vehicleId)
                .filter(v -> v.getStatus() == Status.AVAILABLE)
                .orElseThrow();

        vehicle.setStatus(Status.ASSOCIATED);
        vehicle.setAssociationDate(new Date());
        vehicle.setOwner(userId);

        vehicleRepository.save(vehicle);
    }

    @Override
    public void removeAssociation(String vehicleId, String userId) {
        var vehicle = vehicleRepository.findById(vehicleId)
                .filter(v -> v.getStatus() == Status.ASSOCIATED)
                .filter(v -> v.getOwner().equals(userId))
                .orElseThrow();

        vehicle.setOwner(null);
        vehicle.setAssociationDate(null);
        vehicle.setStatus(Status.AVAILABLE);

        vehicleRepository.save(vehicle);
    }
}
