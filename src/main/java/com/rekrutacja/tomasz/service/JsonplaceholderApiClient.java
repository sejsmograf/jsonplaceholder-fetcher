package com.rekrutacja.tomasz.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rekrutacja.tomasz.config.AppConfig;
import com.rekrutacja.tomasz.model.Post;

public class JsonplaceholderApiClient {

    private final HttpClient client;
    private final ObjectMapper mapper;

    public JsonplaceholderApiClient() {
        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    public List<Post> fetchAllPosts() {
        String postsEndpoint = AppConfig.JSONPLACEHOLDER_API_URL + "/posts";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(postsEndpoint))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            List<Post> posts = mapper.readValue(body, new TypeReference<List<Post>>() {
            });
            return posts;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
