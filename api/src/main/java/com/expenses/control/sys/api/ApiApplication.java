package com.expenses.control.sys.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.expenses.control.sys.api.conf.APIConfig;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		APIConfig.loadEnv();
		SpringApplication.run(ApiApplication.class, args);
	}
}
