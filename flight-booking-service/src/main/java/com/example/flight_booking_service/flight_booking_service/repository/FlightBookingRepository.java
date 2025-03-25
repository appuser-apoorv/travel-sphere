package com.example.flight_booking_service.flight_booking_service.repository;

import com.example.flight_booking_service.flight_booking_service.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

}
