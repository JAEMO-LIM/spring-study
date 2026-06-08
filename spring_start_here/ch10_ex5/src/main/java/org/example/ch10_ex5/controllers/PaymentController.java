package org.example.ch10_ex5.controllers;

import org.example.ch10_ex5.exception.NotEnoughMoneyException;
import org.example.ch10_ex5.model.ErrorDetails;
import org.example.ch10_ex5.model.PaymentDetails;
import org.example.ch10_ex5.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {


    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> payment(@RequestBody PaymentDetails paymentDetails) {
        logger.info("Received payment" + paymentDetails.getAmount());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }

    //    private final PaymentService paymentService;
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping("/payment")
//    public ResponseEntity<?> makePayment() {
//        try{
//            PaymentDetails paymentDetails = paymentService.processPayment();
//
//            return ResponseEntity.status(HttpStatus.ACCEPTED)
//                    .body(paymentDetails);
//        } catch (NotEnoughMoneyException e) {
//            ErrorDetails errorDetails = new ErrorDetails();
//            errorDetails.setMessage("Not enough money");
//            return ResponseEntity.badRequest().body(errorDetails);
//        }
//    }

}
