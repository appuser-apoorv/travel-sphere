package com.example.customer_service.service;

import com.example.customer_service.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerByEmail(String email);
    List<Map<String, Object>> getCustomerBookings(Long customerId);
    List<Map<String, Object>> getCustomerPayments(String email);
    String makePayment(Map<String, Object> paymentRequest);
}
