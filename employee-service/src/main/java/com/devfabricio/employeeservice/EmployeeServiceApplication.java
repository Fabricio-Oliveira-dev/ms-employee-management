package com.devfabricio.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan("com.devfabricio.employeeservice.services.impl.EmployeeServiceImpl")
public class EmployeeServiceApplication {

	/*@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

	/*@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
