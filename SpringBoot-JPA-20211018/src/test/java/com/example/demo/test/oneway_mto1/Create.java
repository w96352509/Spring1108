package com.example.demo.test.oneway_mto1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;

@SpringBootTest
public class Create {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
   
	  @Test
       public void start() {
	      //ManyToOne 預設是 fetch=FetchType.EAGER
		  //所以SQL會進行Left outer join 來聯集其他資料表
		  //手動改成懶連結後就只會單查order(不會搜尋榜定方)
		  Order order = orderRepository.findById(1L).get();
		  System.out.println(order.getName());
		  //但可手動加入查找綁定 , 但會再跑一次綁定方得sql
		  System.out.println(order.getCustomer().getName());
	      
	  }
}
