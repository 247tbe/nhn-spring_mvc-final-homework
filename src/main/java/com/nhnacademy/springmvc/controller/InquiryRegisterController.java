package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.InquiryRegisterRequest;
import com.nhnacademy.springmvc.exception.ValidationFailedException;
import com.nhnacademy.springmvc.repository.InquiryRepository;
import com.nhnacademy.springmvc.validator.InquiryRegisterRequestValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cs/inquiry")
public class InquiryRegisterController {
    private final InquiryRepository inquiryRepository;

    private final InquiryRegisterRequestValidator validator;

    public InquiryRegisterController(InquiryRepository inquiryRepository,
                                     InquiryRegisterRequestValidator validator) {
        this.inquiryRepository = inquiryRepository;
        this.validator = validator;
    }

    @GetMapping
    public String inquiryRegisterForm() {
        return "user/inquiryRegister";
    }

    @PostMapping
    public ModelAndView registerInquiry(@Validated @ModelAttribute InquiryRegisterRequest inquiryRequest,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        inquiryRepository.register(inquiryRequest.getTitle(), inquiryRequest.getCategory(), inquiryRequest.getText());

        ModelAndView mav = new ModelAndView("user/inquiryView");
        mav.addObject("inquiryList", inquiryRepository.getList());

        return mav;
    }

    @InitBinder("inquiryRegisterRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

}
