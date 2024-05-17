package com.lcwd.userservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lcwd.userservice.interceptors.RestTemplateInterceptor;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScans(value = {
			@ComponentScan("com.lcwd.userservice.controllers"),
			@ComponentScan("com.lcwd.userservice.services")
			})
@EntityScan(value = {"com.lcwd.userservice.entities"})
@EnableJpaRepositories(value = {"com.lcwd.userservice.repositories"})
@Import({ClientConfig.class, RestTemplateInterceptor.class, FeginClientInterceptor.class, SecurityConfig.class})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
