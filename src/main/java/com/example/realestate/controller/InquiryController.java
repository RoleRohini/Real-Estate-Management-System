package com.example.realestate.controller;

import com.example.realestate.entity.Inquiry;
import com.example.realestate.service.InquiryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@AllArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    // Create Inquiry
    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(
            @RequestBody Inquiry inquiry) {

        Inquiry savedInquiry = inquiryService.createInquiry(inquiry);

        return new ResponseEntity<>(savedInquiry, HttpStatus.CREATED);
    }

    // Get All Inquiries
    @GetMapping
    public ResponseEntity<List<Inquiry>> getAllInquiries() {

        return ResponseEntity.ok(
                inquiryService.getAllInquiries()
        );
    }

    // Get Inquiry By ID
    @GetMapping("/{id}")
    public ResponseEntity<Inquiry> getInquiryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                inquiryService.getInquiryById(id)
        );
    }

    // Update Inquiry
    @PutMapping("/{id}")
    public ResponseEntity<Inquiry> updateInquiry(
            @PathVariable Long id,
            @RequestBody Inquiry inquiry) {

        return ResponseEntity.ok(
                inquiryService.updateInquiry(id, inquiry)
        );
    }

    // Delete Inquiry
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInquiry(
            @PathVariable Long id) {

        inquiryService.deleteInquiry(id);

        return ResponseEntity.ok(
                "Inquiry deleted successfully"
        );
    }
}