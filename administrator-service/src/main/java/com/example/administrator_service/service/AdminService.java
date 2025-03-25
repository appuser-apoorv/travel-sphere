package com.example.administrator_service.service;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Map<String , Object>> getAllFlights();
    List<Map<String , Object>> getAllHotels();
    List<Map<String , Object>> getAllCustomers();
    String updateFlight(Map<String , Object> flight);
    String updateHotel(Map<String , Object> hotel);
    String deleteCustomer(Long customerId);

}
