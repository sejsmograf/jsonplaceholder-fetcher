package com.tomasz.rekrutacja.json_fetcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tomasz.rekrutacja.json_fetcher.exception.CliExceptionResolver;

@Configuration
public class AppConfig {

	@Bean
	CliExceptionResolver exceptionResolver() {
		return new CliExceptionResolver();
	}
}
