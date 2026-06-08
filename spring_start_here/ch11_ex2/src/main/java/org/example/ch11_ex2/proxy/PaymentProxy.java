package org.example.ch11_ex2.proxy;

import org.springframework.stereotype.Component;

@Component
public class PaymentProxy {

    private final RestTemplate rest;
}
