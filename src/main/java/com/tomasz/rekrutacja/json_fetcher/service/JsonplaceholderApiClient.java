package com.tomasz.rekrutacja.json_fetcher.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.tomasz.rekrutacja.json_fetcher.config.JsonplaceholderApiProperties;
import com.tomasz.rekrutacja.json_fetcher.model.Post;

@Component
public class JsonplaceholderApiClient {
	private final RestClient client;

	public JsonplaceholderApiClient(JsonplaceholderApiProperties properties) {
		client = RestClient.builder()
				.baseUrl(properties.getBaseUrl())
				.defaultStatusHandler(HttpStatusCode::is4xxClientError,
						(req, res) -> {
							throw new HttpClientErrorException(res.getStatusCode(),
									"Api client error: " + res.getStatusCode());
						})
				.build();
	}

	public List<Post> fetchAllPosts() {
		return client.get()
				.uri("/posts")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(new ParameterizedTypeReference<List<Post>>() {
				});
	}
}
