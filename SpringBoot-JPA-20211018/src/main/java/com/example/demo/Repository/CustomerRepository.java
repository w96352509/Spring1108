package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.oneway_mto1.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
