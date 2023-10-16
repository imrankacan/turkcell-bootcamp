package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.repositories.OrderRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrderRepositories orderRepositories;
    public OrdersController(OrderRepositories orderRepositories) {
        this.orderRepositories = orderRepositories;
    }
}
