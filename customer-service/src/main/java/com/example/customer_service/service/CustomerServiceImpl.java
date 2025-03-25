package com.example.customer_service.service;

import com.example.customer_service.entity.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements  CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerServiceImpl(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public List<Map<String, Object>> getCustomerBookings(Long customerId) {
        String flightBookingUrl = "http://FLIGHT-BOOKING-SERVICE/bookings/customer/" + customerId;
        String hotelBookingUrl = "http://HOTEL-BOOKING-SERVICE/hotel-bookings/customer/" + customerId;

        List<Map<String, Object>> flightBookings = restTemplate.getForObject(flightBookingUrl, List.class);
        List<Map<String, Object>> hotelBookings = restTemplate.getForObject(hotelBookingUrl, List.class);

        flightBookings.addAll(hotelBookings);
        return flightBookings;
    }

    public List<Map<String, Object>> getCustomerPayments(String email) {
        String paymentUrl = "http://PAYMENT-SERVICE/payment/customer/" + email;
        return restTemplate.getForObject(paymentUrl, List.class);
    }

    public String makePayment(Map<String, Object> paymentRequest) {
        String paymentUrl = "http://PAYMENT-SERVICE/payment";
        return restTemplate.postForObject(paymentUrl, paymentRequest, String.class);
    }
}
