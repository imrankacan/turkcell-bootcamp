package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.repositories.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrderRepository orderRepositories;
    public OrdersController(OrderRepository orderRepositories) {
        this.orderRepositories = orderRepositories;
    }
}
