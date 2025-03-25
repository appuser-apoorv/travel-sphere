package com.example.hotel_search_service.repository;

import com.example.hotel_search_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelSearchRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocationAndAvailableFromAndAvailableTo(String location, LocalDate checkInDate, LocalDate checkOutDate);
}
