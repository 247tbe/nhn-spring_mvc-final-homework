package com.nhnacademy.springmvc.validator;

import com.nhnacademy.springmvc.domain.AnswerRegisterRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AnswerRegisterRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AnswerRegisterRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "", "comment is empty");

        AnswerRegisterRequest request = (AnswerRegisterRequest) target;
        String comment = request.getComment();
        if (comment.length() > 40_000) {
            errors.rejectValue("comment", "", "comment max length is 40,000");
        }
    }
}
