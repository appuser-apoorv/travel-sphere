package com.example.hotel_search_service.service;

import com.example.hotel_search_service.entity.Hotel;
import com.example.hotel_search_service.repository.HotelSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HotelSearchServiceImpl implements HotelSearchService {

    private final  HotelSearchRepository hotelSearchRepository;

    public HotelSearchServiceImpl(HotelSearchRepository hotelSearchRepository) {
        this.hotelSearchRepository = hotelSearchRepository;
    }

    @Override
    public List<Hotel> searchHotels(String location, LocalDate checkInDate, LocalDate checkOutDate) {
        return hotelSearchRepository.findByLocationAndAvailableFromAndAvailableTo(location, checkInDate, checkOutDate);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelSearchRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return hotelSearchRepository.findById(id);
    }
}
