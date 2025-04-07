package com.tomasz.rekrutacja.json_fetcher.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FileStorageServiceTest {
	private FileStorageService storageService = new FileStorageService();

	@Test
	void saveContentToFileShouldSaveContentToFile(@TempDir Path tmpDir) throws IOException {
		Path file = tmpDir.resolve("file.txt");
		String toWrite = """
				content
				to
				write
				""";

		storageService.saveContentToFile(toWrite, file);

		assertTrue(Files.exists(file));
		assertTrue(Files.readString(file).equals(toWrite));
	}

}
