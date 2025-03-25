package com.example.hotel_booking_service.service;

import com.example.hotel_booking_service.dto.HotelDTO;
import com.example.hotel_booking_service.entity.HotelBooking;
import com.example.hotel_booking_service.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingServiceImpl implements HotelBookingService{


    @Autowired
    private HotelBookingRepository hotelBookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<HotelBooking> getAllHotelBookings() {
        return hotelBookingRepository.findAll();
    }

    @Override
    public Optional<HotelBooking> getBookingById(Long id) {
        return hotelBookingRepository.findById(id);
    }

    @Override
    public HotelBooking createHotelBooking(HotelBooking hotelBooking, Long hotelId) {
        String hotelSearchUrl = "http://HOTEL-BOOKING-SERVICE/bookings" + hotelId;

        HotelDTO hotel = restTemplate.getForObject(hotelSearchUrl, HotelDTO.class);
        if (hotel == null) {
            throw new RuntimeException("Hotel not found");
        }

        hotelBooking.setHotelId(hotelId);
        return hotelBookingRepository.save(hotelBooking);
    }
//        hotelBooking.setHotelId(hotelId);  // Set hotelId from query parameter
//        return hotelBookingRepository.save(hotelBooking);  // Save, id will be auto-generated
    }
