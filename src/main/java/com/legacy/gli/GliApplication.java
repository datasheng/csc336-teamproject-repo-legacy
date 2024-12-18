package com.legacy.gli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.legacy.gli.repository")
@EntityScan(basePackages = "com.legacy.gli.model")
public class GliApplication {

	public static void main(String[] args) {
		SpringApplication.run(GliApplication.class, args);
	}

}
