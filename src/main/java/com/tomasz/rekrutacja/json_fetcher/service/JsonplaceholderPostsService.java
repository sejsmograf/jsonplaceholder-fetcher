package com.tomasz.rekrutacja.json_fetcher.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tomasz.rekrutacja.json_fetcher.model.Post;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JsonplaceholderPostsService implements PostsService {
	private final JsonplaceholderApiClient client;


	@Override
	public List<Post> getAllPosts() {
		return client.fetchAllPosts();
	}
}
