package com.example.demo.entity.oneway_mto1;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//多方
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(length = 50 , nullable = true)
	private String name;
    @Column
	private Integer age;
    //單向多對一 (通常建立在多方)
    //@ManyToOne(fetch = FetchType.LAZY) //懶查詢
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE) 
    //customer_id 指的是一個外鍵(不可以隨便亂輸入 , 要對方表單也有的)
    @JoinColumn(name = "customer_id")
    private Customer customer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
    
  
}
