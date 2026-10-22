package com.example.realestate.service.impl;

import com.example.realestate.entity.Document;
import com.example.realestate.repository.DocumentRepository;
import com.example.realestate.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found with id: " + id));
    }

    @Override
    public Document updateDocument(Long id, Document document) {

        Document existingDocument = getDocumentById(id);

        existingDocument.setDocumentName(document.getDocumentName());
        existingDocument.setDocumentType(document.getDocumentType());
        existingDocument.setFileUrl(document.getFileUrl());
        existingDocument.setStatus(document.getStatus());
        existingDocument.setProperty(document.getProperty());
        existingDocument.setUser(document.getUser());

        return documentRepository.save(existingDocument);
    }

    @Override
    public void deleteDocument(Long id) {
        Document document = getDocumentById(id);
        documentRepository.delete(document);
    }
}