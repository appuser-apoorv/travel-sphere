package com.example.administrator_service.controller;

import com.example.administrator_service.service.AdminService;
import com.example.administrator_service.service.AdminServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

        private final AdminServiceImpl adminServiceImpl;

        public AdminController(AdminServiceImpl adminServiceImpl) {
            this.adminServiceImpl = adminServiceImpl;
        }

        @GetMapping("/flight")
        public List<Map<String, Object>> getAllFlights() {
            return adminServiceImpl.getAllFlights();
        }

        @GetMapping("/hotel")
        public List<Map<String, Object>> getAllHotels() {
            return adminServiceImpl.getAllHotels();
        }

        @GetMapping("/customer")
        public List<Map<String, Object>> getAllCustomers() {
            return adminServiceImpl.getAllCustomers();
        }

        @PostMapping("/flight/update")
        public ResponseEntity<String> updateFlight(@RequestBody Map<String, Object> flightData) {
            return ResponseEntity.ok(adminServiceImpl.updateFlight(flightData));
        }

        @PostMapping("/hotel/update")
        public ResponseEntity<String> updateHotel(@RequestBody Map<String, Object> hotelData) {
            return ResponseEntity.ok(adminServiceImpl.updateHotel(hotelData));
        }

        @DeleteMapping("/customer/{id}")
        public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
            return ResponseEntity.ok(adminServiceImpl.deleteCustomer(id));
        }
    }

