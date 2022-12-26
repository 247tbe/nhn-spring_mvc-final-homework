package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Inquiry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class InquiryRepositoryImpl implements InquiryRepository {
    private final Map<Long, Inquiry> inquiries = new HashMap<>();
    private final List<Inquiry> inquiryList = new ArrayList<>();

    @Override
    public boolean exists(long id) {
        return inquiries.containsKey(id);
    }

    @Override
    public Inquiry register(String title, String category, String text) {
        long id = inquiries.keySet()
            .stream()
            .max(Comparator.comparing(Function.identity()))
            .map(l -> l + 1)
            .orElse(1L);

        Inquiry inquiry = Inquiry.create(title, category, text);
        inquiry.setId(id);

        inquiries.put(id, inquiry);
        inquiryList.add(inquiry);

        return inquiry;
    }

    @Override
    public Inquiry getInquiry(long userId) {
        return exists(userId) ? inquiries.get(userId) : null;
    }

    @Override
    public List<Inquiry> getList() {
        return this.inquiryList;
    }
}
