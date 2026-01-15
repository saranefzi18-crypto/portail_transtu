package tn.transtu.intranet.controller;

import java.util.List;

import tn.transtu.intranet.entity.Document;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.transtu.intranet.repository.DocumentRepository;

@RestController
@RequestMapping("/api/apps/{appId}/docs")

public class DocumentController {
	
	private final DocumentRepository documentRepository;
	
	public DocumentController(DocumentRepository documentRepository) {
	    this.documentRepository = documentRepository;
	}

	@GetMapping
    public List<Document> getDocs(@PathVariable Long appId) {
        return documentRepository.findByApplicationId(appId);
    }
}
