package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Inquiry;
import java.util.List;

public interface InquiryRepository {
    boolean exists(long id);

    Inquiry register(String title, String category, String text);

    Inquiry getInquiry(long userId);

    List<Inquiry> getList();
}
