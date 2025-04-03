
package com.rekrutacja.tomasz.service;

import java.util.List;

import com.rekrutacja.tomasz.model.Post;

public class JsonplaceholderPostService implements PostService {
    private final JsonplaceholderApiClient client;

    public JsonplaceholderPostService(JsonplaceholderApiClient client) {
        this.client = client;
    };

    @Override
    public List<Post> getPosts() {
        return client.fetchAllPosts();
    }

}
