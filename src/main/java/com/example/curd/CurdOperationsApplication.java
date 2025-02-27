package com.example.curd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.curd")
public class CurdOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdOperationsApplication.class, args);
	}

}
