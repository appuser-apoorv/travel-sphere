package com.example.administrator_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements  AdminService{

        private final RestTemplate restTemplate;

        public AdminServiceImpl(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public List<Map<String, Object>> getAllFlights() {
            return restTemplate.getForObject("http://FLIGHT-SEARCH-SERVICE/flight", List.class);
        }

        public List<Map<String, Object>> getAllHotels() {
            return restTemplate.getForObject("http://HOTEL-SEARCH-SERVICE/hotel", List.class);
        }

        public List<Map<String, Object>> getAllCustomers() {
            return restTemplate.getForObject("http://CUSTOMER-SERVICE/customer", List.class);
        }

        public String updateFlight(Map<String, Object> flightData) {
            String flightUrl = "http://FLIGHT-SEARCH-SERVICE/flight/update";
            return restTemplate.postForObject(flightUrl, flightData, String.class);
        }

        public String updateHotel(Map<String, Object> hotelData) {
            String hotelUrl = "http://HOTEL-SEARCH-SERVICE/hotel/update";
            return restTemplate.postForObject(hotelUrl, hotelData, String.class);
        }

        public String deleteCustomer(Long customerId) {
            String customerUrl = "http://CUSTOMER-SERVICE/customer/delete/" + customerId;
            restTemplate.delete(customerUrl);
            return "Customer deleted successfully.";
        }
    }

