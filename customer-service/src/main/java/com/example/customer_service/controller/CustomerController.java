package com.example.customer_service.controller;

import com.example.customer_service.entity.Customer;
import com.example.customer_service.service.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerServiceImpl.getCustomerByEmail(email);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/booking")
    public List<Map<String, Object>> getCustomerBookings(@PathVariable Long id) {
        return customerServiceImpl.getCustomerBookings(id);
    }

    @GetMapping("/{email}/payment")
    public List<Map<String, Object>> getCustomerPayments(@PathVariable String email) {
        return customerServiceImpl.getCustomerPayments(email);
    }

    @PostMapping("/make-payment")
    public String makePayment(@RequestBody Map<String, Object> paymentRequest) {
        return customerServiceImpl.makePayment(paymentRequest);
    }
}

