package com.example.flight_booking_service.flight_booking_service.service;

import com.example.flight_booking_service.flight_booking_service.entity.FlightBooking;

import java.util.List;
import java.util.Map;


public interface FlightBookingService {

    FlightBooking createFlightBooking(FlightBooking flightBooking);

    List<FlightBooking> getAllBooking();

    void deleteBooking(Long id);

}
