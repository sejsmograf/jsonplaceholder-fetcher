package com.tomasz.rekrutacja.json_fetcher.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "jsonplaceholder.api")
@Getter
@Setter
public class JsonplaceholderApiProperties {
	private String baseUrl;
}
