package tn.transtu.intranet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.transtu.intranet.entity.Document;
import tn.transtu.intranet.repository.DocumentRepository;
import tn.transtu.intranet.service.DocumentService;

@RestController
@RequestMapping("/api/apps/{appId}/docs")

public class DocumentController {
	
	private final DocumentRepository documentRepository;
	private final DocumentService service;
	
	public DocumentController(DocumentRepository documentRepository, DocumentService service) {
	    this.documentRepository = documentRepository;
	    this.service=service;
	}

	@GetMapping
    public List<Document> getDocs(@PathVariable Long appId) {
        return documentRepository.findByApplicationId(appId);
    }
	
	@PostMapping("/apps")
	public Document addDoc(@RequestBody Document doc) {
	    return service.addDocument(doc);
	}
	
}
