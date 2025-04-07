package com.tomasz.rekrutacja.json_fetcher.cli;

import java.nio.file.Path;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import com.tomasz.rekrutacja.json_fetcher.service.PostsDownloadService;
import com.tomasz.rekrutacja.json_fetcher.service.FileStorageService;

import lombok.AllArgsConstructor;

@Command
@AllArgsConstructor
public class CliCommands {
	private final PostsDownloadService postDownloadService;
	private final FileStorageService fileStorageService;

	@Command(command = "download-posts", description = "Download posts from jsonplaceholder and save them")
	public String downloadPosts(
			@Option(required = false, shortNames = 'd', longNames = "directory", description = "Specify output directory", defaultValue = ".") String directory) {
		Path dirPath = Path.of(directory);
		fileStorageService.ensureDirExists(dirPath);

		postDownloadService.downloadAndSavePosts(dirPath);
		return "Saved posts successfully to: " + dirPath.toAbsolutePath();
	}
}
