package com.nhnacademy.springmvc.validator;

import com.nhnacademy.springmvc.domain.InquiryRegisterRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class InquiryRegisterRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return InquiryRegisterRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "title is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "", "text is empty");

        InquiryRegisterRequest request = (InquiryRegisterRequest) target;
        String content = request.getText();
        if (content.length() > 40_000) {
            errors.rejectValue("text", "", "text max length is 40,000");
        }
    }
}
