package com.nhnacademy.springmvc.domain;

import lombok.Getter;

public class Answer {
    @Getter
    private final String comment;

    public static Answer create(String comment) {
        return new Answer(comment);
    }

    private Answer(String comment) {
        this.comment = comment;
    }
}
