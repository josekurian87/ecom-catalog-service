package com.secor.ecomcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class EcomCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomCatalogServiceApplication.class, args);
    }

}
