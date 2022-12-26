package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Inquiry;
import com.nhnacademy.springmvc.repository.InquiryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cs")
public class InquiryController {
    private final InquiryRepository inquiryRepository;

    public InquiryController(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @ModelAttribute("inquiry")
    public Inquiry getInquiry(@PathVariable("userId") long userId) {
        return inquiryRepository.getInquiry(userId);
    }

    @GetMapping("/")
    public String viewInquiryList(@ModelAttribute("inquiry") Inquiry inquiry,
                           ModelMap modelMap) {
        modelMap.put("inquiry", inquiry);

        return "user/inquiryView";
    }
}
