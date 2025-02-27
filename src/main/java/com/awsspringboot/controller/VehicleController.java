package com.awsspringboot.controller;

import com.awsspringboot.model.Status;
import com.awsspringboot.model.Vehicle;
import com.awsspringboot.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("vehicles")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        vehicle.setId(UUID.randomUUID().toString());
        vehicle.setStatus(Status.AVAILABLE);
        vehicle.setOwner(null);
        vehicle.setAssociationDate(null);

        return vehicleService.create(vehicle);
    }
}
