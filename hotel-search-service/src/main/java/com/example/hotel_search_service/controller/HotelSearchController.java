package com.example.hotel_search_service.controller;

import com.example.hotel_search_service.entity.Hotel;
import com.example.hotel_search_service.service.HotelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelSearchController {

    private final HotelSearchService hotelSearchService;

    public HotelSearchController(HotelSearchService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels(){
        return hotelSearchService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getHotelById(@PathVariable Long id) {
        return hotelSearchService.findById(id);
    }

    @GetMapping("/search")
    public List<Hotel> searchHotel(@RequestParam String location,
                                   @RequestParam LocalDate checkInDate,
                                   @RequestParam LocalDate checkOutDate) {
        return hotelSearchService.searchHotels(location,checkInDate, checkOutDate);
    }
    // get re request mapping - http://localhost:8083/hotel/search?location=Bhopal&checkInDate=2025-02-04&checkOutDate=2025-02-06

}
