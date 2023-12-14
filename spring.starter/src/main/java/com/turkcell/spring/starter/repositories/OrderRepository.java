package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<Order,Integer> {
}
