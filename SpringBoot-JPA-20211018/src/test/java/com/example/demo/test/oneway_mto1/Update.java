package com.example.demo.test.oneway_mto1;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;

@SpringBootTest
public class Update {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
   
	  @Test
       public void start() {
	     //假設要更改id=1客戶年齡
		 Order order = orderRepository.findById(1L).get();
		 Customer customer = order.getCustomer(); //order綁定的Customer
		 
		 order.setName("A-1");
		 customer.setAge(20);
		 // 進行資料儲存
		 //orderRepository.save(order);
		 //customerRepository.save(customer);
		 
		 //進行資料保存-聯集保存
		 //在 @ManyToOne中加入cascade = CascadeType.MERGE
		 //會由系統幫你更新你綁定的物件方法等
		 //EX:customer是由order所拿出 , 下達@ManyToOne中加入cascade = CascadeType.MERGE後
		 //customer的方法就可以從order所控制
		 //所以save order即可
		 orderRepository.save(order);
		//customerRepository.save(customer); 可以不用寫 , 會由系統自動產生
	 }
}
