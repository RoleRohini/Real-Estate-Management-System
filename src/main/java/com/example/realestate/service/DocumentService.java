package com.example.realestate.service;

import com.example.realestate.entity.Document;

import java.util.List;

public interface DocumentService {

    Document createDocument(Document document);

    List<Document> getAllDocuments();

    Document getDocumentById(Long id);

    Document updateDocument(Long id, Document document);

    void deleteDocument(Long id);
}