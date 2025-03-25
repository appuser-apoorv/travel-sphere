package com.example.FlightSearchService.flight_search_service.controller;

import com.example.FlightSearchService.flight_search_service.entity.Flight;
import com.example.FlightSearchService.flight_search_service.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {

    @Autowired
    private FlightSearchService flightSearchService;

    @GetMapping("search")
    public List<Flight> searchFlight(@RequestParam String origin ,
                                     @RequestParam String destination ,
                                     @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate departureDate){
        return flightSearchService.searchFlight(origin , destination, departureDate);
    }

    @GetMapping("searchByOrigin")
    public  List<Flight> searchByOrigin(@RequestParam String origin) {
        return flightSearchService.searchByOrigin(origin);
    }
}
