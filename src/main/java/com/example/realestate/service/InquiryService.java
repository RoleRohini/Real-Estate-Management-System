package com.example.realestate.service;

import com.example.realestate.entity.Inquiry;

import java.util.List;

public interface InquiryService {

    Inquiry createInquiry(Inquiry inquiry);

    List<Inquiry> getAllInquiries();

    Inquiry getInquiryById(Long id);

    Inquiry updateInquiry(Long id, Inquiry inquiry);

    void deleteInquiry(Long id);
}