package tn.transtu.intranet.service;

import java.time.LocalDateTime;
import java.util.List;
import tn.transtu.intranet.entity.Document;
import org.springframework.stereotype.Service;
import tn.transtu.intranet.entity.Application;
import tn.transtu.intranet.repository.ApplicationRepository;
import tn.transtu.intranet.repository.DocumentRepository;

@Service
public class DocumentService {
	
	private final DocumentRepository documentRepository;
    private final ApplicationRepository applicationRepository;
    
    public DocumentService(DocumentRepository documentRepository, ApplicationRepository applicationRepository) {
        this.documentRepository = documentRepository;
        this.applicationRepository = applicationRepository;
    }
    
    public List<Document> getDocsByApplicationId(Long appId) {
        if (!applicationRepository.existsById(appId)) {
            throw new RuntimeException("Application not found with id: " + appId);
        }
        return documentRepository.findByApplicationId(appId);
    }
    
    public Document addDocument(Long appId, Document document) {
        Application app = applicationRepository.findById(appId).orElseThrow(() -> new RuntimeException("Application not found with id: " + appId));

        document.setApplication(app);
        document.setUpdatedAt(LocalDateTime.now());
        return documentRepository.save(document);
    }
    
    public Document updateDocument(Long docId, Document updatedDocument) {
        Document doc = documentRepository.findById(docId).orElseThrow(() -> new RuntimeException("Document not found with id: " + docId));

        doc.setTitle(updatedDocument.getTitle());
        doc.setType(updatedDocument.getType());
        doc.setUrl(updatedDocument.getUrl());
        doc.setUpdatedAt(LocalDateTime.now());

        return documentRepository.save(doc);
    }
    
    public void deleteDocument(Long docId) {
        Document doc = documentRepository.findById(docId).orElseThrow(() -> new RuntimeException("Document not found with id: " + docId));
        documentRepository.delete(doc);
    }
    
}
