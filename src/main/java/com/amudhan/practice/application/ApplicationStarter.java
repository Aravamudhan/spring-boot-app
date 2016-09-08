package com.amudhan.practice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
@ComponentScan(basePackages = "com.amudhan.practice")
@ImportResource("applicationContext-core.xml")
public class ApplicationStarter {
	
	public static void main(String[] args){
		new EmbeddedDatabaseBuilder().setName("classicmodels")
		.setType(EmbeddedDatabaseType.H2)
		.addScript("classpath:/config/import.sql").build();
		SpringApplication.run(ApplicationStarter.class, args);
	}
	
}
