package com.cicd.kdramafinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.cicd.kdramafinder.repository"})
@EntityScan(basePackages = {"com.cicd.kdramafinder.entity"})

public class KdramafinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(KdramafinderApplication.class, args);
		System.out.println("hi");
		}

}
