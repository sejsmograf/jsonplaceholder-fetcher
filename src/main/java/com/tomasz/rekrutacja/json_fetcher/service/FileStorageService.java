package com.tomasz.rekrutacja.json_fetcher.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

@Service
public class FileStorageService implements StorageService {

	public void saveContentToFile(String content, Path filePath) {
		Path dir = filePath.getParent();

		try {
			Files.writeString(filePath, content);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public boolean ensureDirExists(Path dir) {
		return Files.isDirectory(dir);
	}
}
