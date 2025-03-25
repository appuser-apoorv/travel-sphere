package com.example.hotel_search_service.service;

import com.example.hotel_search_service.entity.Hotel;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HotelSearchService {
    List<Hotel> searchHotels(String location, LocalDate checkInDate, LocalDate checkOutDate);

    List<Hotel> getAllHotels();

    Optional<Hotel> findById(Long id);
}
