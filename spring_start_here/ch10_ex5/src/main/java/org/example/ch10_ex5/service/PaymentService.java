package org.example.ch10_ex5.service;

import org.example.ch10_ex5.exception.NotEnoughMoneyException;
import org.example.ch10_ex5.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
