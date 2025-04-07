package com.tomasz.rekrutacja.json_fetcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
