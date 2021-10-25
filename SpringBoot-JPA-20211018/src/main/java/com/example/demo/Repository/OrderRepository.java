package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
