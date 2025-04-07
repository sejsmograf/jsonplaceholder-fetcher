package com.tomasz.rekrutacja.json_fetcher.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import com.tomasz.rekrutacja.json_fetcher.model.Post;

@ExtendWith(MockitoExtension.class)
public class JsonplaceholderPostsServiceTest {

	@Mock
	private JsonplaceholderApiClient client;

	@InjectMocks
	private JsonplaceholderPostsService postsService;

	@Test
	void shouldReturnPostsWhenGetPosts() {
		Post post = new Post(1L, 1L, "Title", "body");
		var posts = List.of(post);
		when(client.fetchAllPosts()).thenReturn(posts);

		var result = postsService.getAllPosts();

		assertEquals(result.size(), 1);
	}

	@Test
	void shouldThrowWhenClientThrows() {
		when(client.fetchAllPosts()).thenThrow(new HttpClientErrorException(HttpStatusCode.valueOf(404)));

		assertThrows(
				HttpClientErrorException.class,
				() -> postsService.getAllPosts());
	}
}
