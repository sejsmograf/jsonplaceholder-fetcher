package com.rekrutacja.tomasz.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

import com.rekrutacja.tomasz.config.AppConfig;
import com.rekrutacja.tomasz.exception.ApiException;

public class JsonplaceholderApiClient {

    private final HttpClient client;
    private static final Logger logger = Logger.getLogger(JsonplaceholderApiClient.class.getName());

    public JsonplaceholderApiClient() {
        this.client = HttpClient.newBuilder()
                .connectTimeout(AppConfig.HTTP_CLIENT_TIMEOUT)
                .build();
    }

    public String fetchAllPostsRaw() {
        String postsEndpoint = AppConfig.JSONPLACEHOLDER_API_URL + "/posts";
        logger.info(String.format("Fetching posts from %s", postsEndpoint));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(postsEndpoint))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new ApiException(String.format("%s API failed with status code: %d",
                        AppConfig.JSONPLACEHOLDER_API_URL, response.statusCode()));
            }

            String body = response.body();
            return body;
        } catch (IOException | InterruptedException e) {
            throw new ApiException(
                    String.format("HttpClient failed to send request: %s, cause: %s", request.toString(),
                            e.getMessage()),
                    e);
        }
    }
}
