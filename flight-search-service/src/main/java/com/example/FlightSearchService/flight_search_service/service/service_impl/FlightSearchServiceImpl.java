package com.example.FlightSearchService.flight_search_service.service.service_impl;

import com.example.FlightSearchService.flight_search_service.entity.Flight;
import com.example.FlightSearchService.flight_search_service.repository.FlightRepository;
import com.example.FlightSearchService.flight_search_service.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Flight> searchFlight(String origin, String destination, LocalDate departureDate) {
        return flightRepository.findByOriginAndDestinationAndDepartureDate(origin, destination , departureDate);
    }

    @Override
    public List<Flight> searchByOrigin(String origin) {
        String url = "http://hotel-search/hotels/search?location=" + origin;
        Flight[] flights = restTemplate.getForObject(url, Flight[].class);
        return Arrays.asList(flights);
//        return flightRepository.findByOrigin(origin);
    }
}
