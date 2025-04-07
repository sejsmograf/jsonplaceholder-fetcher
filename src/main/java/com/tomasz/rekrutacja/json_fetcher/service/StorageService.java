package com.tomasz.rekrutacja.json_fetcher.service;

import java.nio.file.Path;

public interface StorageService {
	void saveContentToFile(String content, Path path);

	boolean ensureDirExists(Path dir);
}
