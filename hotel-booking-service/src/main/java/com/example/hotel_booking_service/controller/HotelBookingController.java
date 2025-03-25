package com.example.hotel_booking_service.controller;

import com.example.hotel_booking_service.entity.HotelBooking;
import com.example.hotel_booking_service.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel-booking")
public class HotelBookingController {

    @Autowired
    private HotelBookingService hotelBookingService;

    @GetMapping("/all")
    public List<HotelBooking> getAllHotelBookings(){
        return hotelBookingService.getAllHotelBookings();
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<HotelBooking> getBookingById(@PathVariable Long id) {
       return hotelBookingService.getBookingById(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping("/create")
    public HotelBooking createHotelBooking(@RequestBody HotelBooking hotelBooking, @RequestParam Long hotelId){
        return hotelBookingService.createHotelBooking(hotelBooking, hotelId);
    }
}
