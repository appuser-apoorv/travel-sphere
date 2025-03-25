package com.example.FlightSearchService.flight_search_service.service;

import com.example.FlightSearchService.flight_search_service.entity.Flight;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface FlightSearchService {

    public List<Flight> searchFlight(String origin , String destination , LocalDate departureDate);

    public List<Flight> searchByOrigin(String origin);
}
