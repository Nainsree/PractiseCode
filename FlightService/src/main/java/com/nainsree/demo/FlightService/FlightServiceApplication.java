package com.nainsree.demo.FlightService;

import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceApplication.class, args);
	}
	//https://www.baeldung.com/hibernate-field-naming-spring-boot
	//above link has description for naming strategy in spring boot 
	  @Bean
	  public PhysicalNamingStrategy physical() { return new
	  PhysicalNamingStrategyStandardImpl(); }
	  
	 @Bean
	 public ImplicitNamingStrategy implicit() { return new
	 ImplicitNamingStrategyLegacyJpaImpl(); }
	

}
