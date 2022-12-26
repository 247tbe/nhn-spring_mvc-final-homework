package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class Inquiry {
    @Getter
    @Setter
    private long id;
    @Getter
    private final String title;
    @Getter
    private final String category;
    @Getter
    private final String text;

    public static Inquiry create(String title, String category, String content) {
        return new Inquiry(title, category, content);
    }

    private Inquiry(String title, String category, String text) {
        this.title = title;
        this.category = category;
        this.text = text;
    }

}
