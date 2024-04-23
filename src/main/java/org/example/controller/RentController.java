package org.example.controller;

import org.example.dao.hibernate.VehicleDAO;
import org.example.dto.RentCarDto;
import org.example.model.Vehicle;
import org.example.service.RentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    private final RentService rentService;
    private final VehicleDAO vehicleDAO;

    public RentController(RentService rentService, VehicleDAO vehicleDAO) {
        this.rentService = rentService;
        this.vehicleDAO = vehicleDAO;
    }

    @PostMapping("/rent")
    public ResponseEntity<String> rentVehicle(@RequestBody RentCarDto request) {
        boolean success = rentService.rentVehicle(request.getPlate(),request.getLogin());
        if (success) {
            return ResponseEntity.ok("Vehicle rented");
        } else {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @GetMapping ("/vehicle/{plate}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String plate){
        Vehicle vehicle = rentService.getVehicle(plate);
        if(vehicle != null){
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}