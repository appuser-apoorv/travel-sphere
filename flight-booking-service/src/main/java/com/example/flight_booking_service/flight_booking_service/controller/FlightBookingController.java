package com.example.flight_booking_service.flight_booking_service.controller;

import com.example.flight_booking_service.flight_booking_service.entity.FlightBooking;
import com.example.flight_booking_service.flight_booking_service.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flightBooking")
public class FlightBookingController {

    @Autowired
    FlightBookingService flightBookingService;

    @PostMapping("/create")
    public FlightBooking createFlightBooking(@RequestBody FlightBooking flightBooking){
        return flightBookingService.createFlightBooking(flightBooking);
    }

    @GetMapping("/getAll")
    public List<FlightBooking> getAllBooking(){
        return flightBookingService.getAllBooking();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id)
    {
        flightBookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking Deleted Successfully");
    }
}
