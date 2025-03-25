package com.example.hotel_booking_service.test.service;

import com.example.hotel_booking_service.repository.HotelBookingRepository;
import com.example.hotel_booking_service.service.HotelBookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class HotelBookingServiceImplTest {

   @Mock
    private HotelBookingRepository hotelBookingRepository;

   @Mock
    private RestTemplate restTemplate;

   @InjectMocks
    private HotelBookingServiceImpl hotelBookingServiceImpl;

   @BeforeEach
    void setUp(){
       MockitoAnnotations.openMocks(this);
   }

   @Test
   void getAllHotelBookings(){
       
   }
}