package com.example.FlightSearchService.flight_search_service.repository;

import com.example.FlightSearchService.flight_search_service.entity.Flight;
import com.fasterxml.jackson.databind.DatabindException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByOriginAndDestinationAndDepartureDate(String origin , String destination , LocalDate departureDate);

    List<Flight> findByOrigin(String origin);
}
