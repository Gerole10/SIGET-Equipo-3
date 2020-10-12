package com.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dao.AgenteBD;


@SpringBootApplication
@ComponentScan ({"com.controller", "com.model", "com.principal", "com.service"})
@EnableMongoRepositories ("com.dao") // this fix the problem
public class SigetEquipo3Application {

	public static void main(String[] args) {
		SpringApplication.run(SigetEquipo3Application.class, args);	
		
	}
}
