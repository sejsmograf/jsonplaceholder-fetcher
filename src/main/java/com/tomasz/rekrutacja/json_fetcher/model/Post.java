package com.tomasz.rekrutacja.json_fetcher.model;

import lombok.Data;

@Data
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
