package com.tomasz.rekrutacja.json_fetcher.cli;

import java.nio.file.Path;
import java.security.InvalidParameterException;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import com.tomasz.rekrutacja.json_fetcher.service.PostsDownloadService;
import com.tomasz.rekrutacja.json_fetcher.service.StorageService;

import lombok.AllArgsConstructor;

@Command
@AllArgsConstructor
public class CliCommands {
	private final PostsDownloadService postDownloadService;
	private final StorageService storageService;

	@Command(command = "download-posts", description = "Download and save posts")
	public String downloadPosts(
			@Option(required = false, shortNames = 'd', longNames = "directory", description = "Specify output directory", defaultValue = ".") String directory) {
		Path dirPath = Path.of(directory);
		if (!storageService.ensureDirExists(dirPath)) {
			throw new InvalidParameterException("Directory " + directory.toString() + " doesn't exist. Operation failed");
		}

		postDownloadService.downloadAndSavePosts(dirPath);
		return "Saved posts successfully to: " + dirPath.toAbsolutePath();
	}
}
