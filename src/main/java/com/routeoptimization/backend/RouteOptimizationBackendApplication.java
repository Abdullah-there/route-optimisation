package com.routeoptimization.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.routeoptimization.backend.Entity")
@EnableJpaRepositories("com.routeoptimization.backend.Repository")
public class RouteOptimizationBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouteOptimizationBackendApplication.class, args);
    }
}
