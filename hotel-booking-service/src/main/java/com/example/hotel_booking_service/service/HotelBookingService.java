package com.example.hotel_booking_service.service;

import com.example.hotel_booking_service.entity.HotelBooking;

import java.util.List;
import java.util.Optional;

public interface HotelBookingService {
    List<HotelBooking> getAllHotelBookings();

    Optional<HotelBooking> getBookingById(Long id);

    HotelBooking createHotelBooking(HotelBooking hotelBooking , Long hotelId);
}
