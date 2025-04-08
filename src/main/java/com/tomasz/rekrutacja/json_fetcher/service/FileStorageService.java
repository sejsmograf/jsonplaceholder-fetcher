package com.tomasz.rekrutacja.json_fetcher.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

@Service
public class FileStorageService implements StorageService {

	public void saveContentToFile(String content, Path filePath) {
		try {
			Files.writeString(filePath, content);
		} catch (AccessDeniedException e) {
			throw new RuntimeException("Access denied attempting to access " + filePath.toString());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public boolean checkDirExists(Path dir) {
		return Files.isDirectory(dir);
	}
}
