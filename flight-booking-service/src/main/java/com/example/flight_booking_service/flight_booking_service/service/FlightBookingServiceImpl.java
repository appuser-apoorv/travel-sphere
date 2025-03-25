package com.example.flight_booking_service.flight_booking_service.service;

import com.example.flight_booking_service.flight_booking_service.entity.FlightBooking;
import com.example.flight_booking_service.flight_booking_service.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlightBookingServiceImpl implements FlightBookingService{

    private  final FlightBookingRepository flightBookingRepository;

    public FlightBookingServiceImpl(FlightBookingRepository flightBookingRepository){
        this.flightBookingRepository = flightBookingRepository;

    }

    @Override
    public FlightBooking createFlightBooking(FlightBooking flightBooking) {
        return flightBookingRepository.save(flightBooking);
    }

    @Override
    public List<FlightBooking> getAllBooking(){
        return flightBookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Long id) {
        flightBookingRepository.deleteById(id);
    }


}
