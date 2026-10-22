package com.example.realestate.service.impl;

import com.example.realestate.entity.Inquiry;
import com.example.realestate.repository.InquiryRepository;
import com.example.realestate.service.InquiryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;

    @Override
    public Inquiry createInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    @Override
    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    @Override
    public Inquiry getInquiryById(Long id) {
        return inquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inquiry not found with id: " + id));
    }

    @Override
    public Inquiry updateInquiry(Long id, Inquiry inquiry) {

        Inquiry existingInquiry = getInquiryById(id);

        existingInquiry.setName(inquiry.getName());
        existingInquiry.setEmail(inquiry.getEmail());
        existingInquiry.setPhone(inquiry.getPhone());
        existingInquiry.setMessage(inquiry.getMessage());
        existingInquiry.setStatus(inquiry.getStatus());
        existingInquiry.setProperty(inquiry.getProperty());
        existingInquiry.setUser(inquiry.getUser());
        existingInquiry.setAgentId(inquiry.getAgentId());

        return inquiryRepository.save(existingInquiry);
    }

    @Override
    public void deleteInquiry(Long id) {
        Inquiry inquiry = getInquiryById(id);
        inquiryRepository.delete(inquiry);
    }
}