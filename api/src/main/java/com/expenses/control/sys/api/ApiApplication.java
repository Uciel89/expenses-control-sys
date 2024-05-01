package com.expenses.control.sys.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.expenses.control.sys.api.conf.APIConfig;

@SpringBootApplication
public class ApiApplication {
	
	public static void main(String[] args) {
		APIConfig.loadEnv();
		SpringApplication.run(ApiApplication.class, args);
	}

}
