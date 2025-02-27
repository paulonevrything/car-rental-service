package com.awsspringboot.controller;

import com.awsspringboot.model.Vehicle;
import com.awsspringboot.service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
}
