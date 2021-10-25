package com.example.demo.oneway_1tom;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "infects")
public class Infect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = true)
	private String name;

	//單向一對多
	//@OneToMany
	@OneToMany(cascade = CascadeType.PERSIST) //PERSIST新增
	@JoinColumn(name = "infect_id") //關聯KEY欄位放在多的一方 I(傳染病單方) V(疫苗多方)
	//因為多方疫苗對應單一疾病ID EX:AZ KEY:ID1(COD) ...
	private Set<Vaccine> vaccines = new LinkedHashSet<>();//綁定多的一方

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

	public Set<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(Set<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	
	
}
