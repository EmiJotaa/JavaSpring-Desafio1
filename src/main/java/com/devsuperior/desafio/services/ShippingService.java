package com.devsuperior.desafio.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double sumShipping(double basic) {
        if (basic < 100.00) {
            return 20.00;
        } else if (basic < 200.00) {
            return 12.00;
        } else {
            return 0.00;
        }
    }
}
