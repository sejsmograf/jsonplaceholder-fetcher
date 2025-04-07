package com.tomasz.rekrutacja.json_fetcher.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidParameterException;

import org.springframework.stereotype.Service;

@Service
public class FileStorageService {

	public void saveContentToFile(String content, Path filePath) {
		Path dir = filePath.getParent();
		ensureDirExists(dir);

		try {
			Files.writeString(filePath, content);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public boolean ensureDirExists(Path dir) {
		if (!Files.isDirectory(dir)) {
			throw new InvalidParameterException("Directory " + dir.toString() + " doesn't exist");
		}
		return true;
	}
}
