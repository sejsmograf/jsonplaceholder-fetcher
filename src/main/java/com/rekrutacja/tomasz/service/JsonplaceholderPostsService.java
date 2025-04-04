
package com.rekrutacja.tomasz.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rekrutacja.tomasz.exception.ResponseParsingException;
import com.rekrutacja.tomasz.model.Post;

public class JsonplaceholderPostsService implements PostService {
    private final JsonplaceholderApiClient client;
    private final ObjectMapper mapper;

    public JsonplaceholderPostsService(JsonplaceholderApiClient client) {
        this.client = client;
        this.mapper = new ObjectMapper();
    };

    @Override
    public List<Post> getPosts() {
        String postsRaw = client.fetchAllPostsRaw();
        try {
            List<Post> posts = mapper.readValue(postsRaw, new TypeReference<List<Post>>() {
            });
            return posts;
        } catch (JsonProcessingException e) {
            throw new ResponseParsingException("Failed to parse response");
        }
    }

}
