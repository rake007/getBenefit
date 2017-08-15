package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.getbenefit.Customer","com.getbenefit.Orders","com.example.demo"})
@EntityScan({"com.getbenefit.Customer","com.getbenefit.Orders","com.example.demo"})
@EnableJpaRepositories({"com.getbenefit.Customer","com.getbenefit.Orders","com.example.demo"})

public class GetBenefitSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetBenefitSpringBootApplication.class, args);
	}
}
