package com.tomasz.rekrutacja.json_fetcher.service;

import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tomasz.rekrutacja.json_fetcher.model.Post;

@Service
public class PostsDownloadService {
	private final PostsService postsService;
	private final StorageService storageService;
	private final ObjectMapper mapper;

	public PostsDownloadService(PostsService postsService, StorageService storageService) {
		this.postsService = postsService;
		this.storageService = storageService;
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	public void downloadAndSavePosts(Path directory) {
		List<Post> posts = postsService.getAllPosts();

		for (Post post : posts) {
			Path filePath = directory.resolve(post.getId().toString() + ".json");
			String prettified = prettifyPost(post);
			storageService.saveContentToFile(prettified, filePath);
		}
	}

	private String prettifyPost(Post post) {
		try {
			return mapper.writeValueAsString(post);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error prettyfing post");
		}
	}
}
