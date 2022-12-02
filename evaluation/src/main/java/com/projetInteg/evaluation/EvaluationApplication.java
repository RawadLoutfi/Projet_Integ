package com.projetInteg.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EvaluationApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvaluationApplication.class, args);
    }
}

