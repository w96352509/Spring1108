package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.oneway_1tom.Infect;
import com.example.demo.oneway_1tom.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
