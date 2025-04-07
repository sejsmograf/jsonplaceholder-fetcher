package com.tomasz.rekrutacja.json_fetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan
@ConfigurationPropertiesScan
public class JsonFetcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonFetcherApplication.class, args);
	}

}
