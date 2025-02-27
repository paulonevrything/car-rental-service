package com.awsspringboot.controller;

import com.awsspringboot.model.Vehicle;
import com.awsspringboot.service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("{vehicleId}")
    public Vehicle get(@PathVariable String vehicleId) {
        return vehicleService.findById(vehicleId);
    }

    @PostMapping
    public Vehicle create(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }

    @PostMapping("{vehicleId}/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void associate(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleService.associate(vehicleId, userId);
    }

    @DeleteMapping("{vehicleId}/user/{userId}")
    public void removeAssociation(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleService.removeAssociation(vehicleId, userId);
    }
}
