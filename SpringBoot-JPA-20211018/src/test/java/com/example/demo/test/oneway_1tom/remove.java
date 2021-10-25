package com.example.demo.test.oneway_1tom;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.InfectRepository;
import com.example.demo.Repository.VaccineRepository;
import com.example.demo.oneway_1tom.Infect;
import com.example.demo.oneway_1tom.Vaccine;

@SpringBootTest
public class remove {
    @Autowired
	InfectRepository infectRepository;
	@Autowired
	VaccineRepository vaccineRepository;
    
	@Test
	public void begin() {
		
	}
	
}
