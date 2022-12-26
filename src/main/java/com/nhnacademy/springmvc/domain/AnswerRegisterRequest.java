package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class AnswerRegisterRequest {
    @NotBlank
    @Size(min = 1, max = 40_000)
    String comment;
}
