package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class InquiryRegisterRequest {
    @Length(min = 2, max = 200)
    String title;
    @NotBlank
    String category;
    @NotBlank
    @Length(max = 40_000)
    String text;
}
