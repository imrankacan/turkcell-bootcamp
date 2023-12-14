package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.OrderDetailService;
import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.business.exceptions.BusinessException;
import com.turkcell.spring.starter.entities.Customer;
import com.turkcell.spring.starter.entities.Employee;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.starter.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;

    public OrderManager(OrderRepository orderRepository, OrderDetailService orderDetailService) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
    }

    @Override
    @Transactional //Metot başarılı bir şekilde tamamlandıktan sonra işlemleri kaydeder (Ör Para Havale)
    public void add(OrderForAddDto request) {
        //Order i DB ye kaydet, order in bir id si oluşsun
        // Olusan id yi ve itemleri orderDetail Service gönder o da bu id ye detay eklemeleri yapsın

        Order order = Order.builder()
                .customer(Customer.builder().customerId(request.getCustomerId()).build())
                .orderDate(LocalDate.now())//O anın saatini alır
                .employee(Employee.builder().employeeId(request.getEmployeeId()).build())
                //.requiredDate(request.getRequiredDate())
                .ship_address(request.getShipAddress())
                //.shipCity(request.getShipCity())
                //.shipName(request.getShipName())
                .build();
        order = orderRepository.save(order);
        //Bu satırdan sonra order in id alanı set edilmiş olacak

        //throw new BusinessException(".");

        orderDetailService.addItemsToOrder(order, request.getItems());

    }
}
