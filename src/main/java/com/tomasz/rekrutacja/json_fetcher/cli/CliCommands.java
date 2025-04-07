package com.tomasz.rekrutacja.json_fetcher.cli;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tomasz.rekrutacja.json_fetcher.service.PostsService;

import lombok.AllArgsConstructor;

@Command
@AllArgsConstructor
public class CliCommands {
	private final PostsService service;

	@ExceptionHandler
	public String handleException(Exception e) {
		return "MANDZIO";
	}

	@Command(command = "download-posts", description = "Download posts from jsonplaceholder and save them")
	public String downloadPosts(
			@Option(required = false, shortNames = 'd', longNames = "directory", description = "Specify output directory", defaultValue = ".") String directory) {
		return service.getAllPosts().toString();
	}
}
