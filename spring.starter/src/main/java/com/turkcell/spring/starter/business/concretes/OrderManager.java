package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.OrderDetailService;
import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.entities.Customer;
import com.turkcell.spring.starter.entities.Employee;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.starter.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor // Servislerde Constructerları otomotik oluşturması için kullanabiliriz
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;
    private final ModelMapper modelMapper;

   /* public OrderManager(OrderRepository orderRepository, OrderDetailService orderDetailService) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
    }*/

    @Override
    @Transactional //Metot başarılı bir şekilde tamamlandıktan sonra işlemleri kaydeder (Ör Para Havale)
    public void add(OrderForAddDto request) {
        //Order i DB ye kaydet, order in bir id si oluşsun
        // Olusan id yi ve itemleri orderDetail Service gönder o da bu id ye detay eklemeleri yapsın


        /* Manuel Mapleme
        Order order = Order.builder()
                .customer(Customer.builder().customerId(request.getCustomerId()).build())
                .orderDate(LocalDate.now())//O anın saatini alır
                .employee(Employee.builder().employeeId(request.getEmployeeId()).build())
                //.requiredDate(request.getRequiredDate())
                .ship_address(request.getShipAddress())
                //.shipCity(request.getShipCity())
                //.shipName(request.getShipName())
                .build();*/

        Order orderFromAutoMapping = modelMapper.map(request, Order.class); //Request kaynağını kullanarak, order.class türünde obje üret

        orderFromAutoMapping = orderRepository.save(orderFromAutoMapping);
        //Bu satırdan sonra order in id alanı set edilmiş olacak

        //throw new BusinessException(".");

        orderDetailService.addItemsToOrder(orderFromAutoMapping, request.getItems());

    }
}
