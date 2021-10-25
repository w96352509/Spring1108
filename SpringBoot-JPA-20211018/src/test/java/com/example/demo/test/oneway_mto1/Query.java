package com.example.demo.test.oneway_mto1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;

@SpringBootTest
public class Query {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
   
	  @Test
       public void start() {
	   System.out.println("create");
	   Customer c1 = new Customer();
	   c1.setName("John");
	   c1.setAge(20);
	   
	   Order order = new Order();
	   order.setName("A-1");
	   
	   Order order2 = new Order();
	   order2.setName("B-2");
	   
	   //設置關聯性
	   order.setCustomer(c1);
	   order2.setCustomer(c1);
	   
	   //執行單向多對一的保存 
	   //(先存優先綁定物件)
	   customerRepository.save(c1); //單方
	   orderRepository.save(order); //多方
	   orderRepository.save(order2);//多方
	 }
}
