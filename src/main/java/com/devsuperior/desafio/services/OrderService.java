package com.devsuperior.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio.entities.Order;

@Service
public class OrderService {

    private final ShippingService shippingService;

    @Autowired
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double sumTotal(Order order) {

        double discountValue = order.sumDiscount();

        double shipping = shippingService.sumShipping(order.getBasic());

        return discountValue + shipping;
    }
}
