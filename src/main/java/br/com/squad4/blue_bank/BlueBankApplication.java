package br.com.squad4.blue_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BlueBankApplication{

	public static void main(String[] args) {
		SpringApplication.run(BlueBankApplication.class, args);
	}	
	

}
