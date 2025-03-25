package com.example.payment_service.controller;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    public PaymentServiceImpl paymentServiceImpl;

    public  PaymentController(PaymentServiceImpl paymentServiceImpl){
        this.paymentServiceImpl = paymentServiceImpl;
    }

    @GetMapping("/customer/{email}")
    public List<Payment> getPaymentsByCustomer(@PathVariable String email) {
        return paymentServiceImpl.getPaymentsByCustomer(email);
    }

    @PostMapping("/process")
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentServiceImpl.processPayment(payment);
    }
}
