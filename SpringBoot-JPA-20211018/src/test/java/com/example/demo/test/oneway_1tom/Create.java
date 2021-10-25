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
public class Create {
    @Autowired
	InfectRepository infectRepository;
	@Autowired
	VaccineRepository vaccineRepository;
    
	@Test
	public void begin() {
		System.out.println("Test");
		Infect infect = new Infect();
		infect.setName("COVID");
		
		Vaccine v1 = new Vaccine();
		v1.setName("AZ");
		v1.setCount(2);
		Vaccine v2 = new Vaccine();
		v2.setName("BNT");
		v2.setCount(2);
		Vaccine v3 = new Vaccine();
		v3.setName("JP");
		
		//設置關聯性
		infect.getVaccines().add(v1);
		infect.getVaccines().add(v2);
		infect.getVaccines().add(v3);
		
		//執行保存 
		//單向一對多 , 因為事由一方來維護多方的關聯欄位 , 所以會增加updata 語句
		//先確定有幾個多方綁定(infect_id欄位) , 再放入單方更新
		//vaccineRepository.save(v1);
		//vaccineRepository.save(v2);
		//vaccineRepository.save(v3);
		//infectRepository.save(infect); //要先知道有幾個多方
		
		//(單向一對多)聯集保存
		//需配置 cascade = CascadeType.PERSIST
		infectRepository.save(infect);
	}
	
}
