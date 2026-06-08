package org.example.ch12_1_1.controller;

import org.example.ch12_1_1.model.Purchase;
import org.example.ch12_1_1.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/purchase")
public class RestController {
    private final PurchaseRepository purchaseRepository;
    public RestController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePuchase(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
