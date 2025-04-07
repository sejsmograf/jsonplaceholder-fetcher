package com.tomasz.rekrutacja.json_fetcher.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tomasz.rekrutacja.json_fetcher.model.Post;

@ExtendWith(MockitoExtension.class)
public class PostsDownloadServiceTest {

	@Mock
	private PostsService postsService;

	private FileStorageService storageService;

	private PostsDownloadService postsDownloadService;

	@BeforeEach
	void setUp() {
		storageService = new FileStorageService();
		postsDownloadService = new PostsDownloadService(postsService, storageService);
	}

	@Test
	void downloadAndSavePostsShouldCreateFiles(@TempDir Path tmpDir) throws IOException {
		Post post1 = new Post(1L, 1L, "Title", "body");
		Post post2 = new Post(1L, 2L, "Title", "body");
		List<Post> posts = List.of(post1, post2);
		when(postsService.getAllPosts()).thenReturn(posts);

		postsDownloadService.downloadAndSavePosts(tmpDir);

		for (Post post : posts) {
			Path filePath = tmpDir.resolve(post.getId().toString() + ".json");
			System.out.println("Checking file path: " + filePath);
			assertTrue(Files.exists(filePath));
		}
	}
}
