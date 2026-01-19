package tn.transtu.intranet.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.transtu.intranet.entity.Document;
import tn.transtu.intranet.service.DocumentService;

@RestController
@RequestMapping("/api/admin/docs")
public class AdminDocumentController {

	private final DocumentService service;
	 
	public AdminDocumentController(DocumentService service) {
	    this.service = service;
	}
	 
	@PostMapping("/apps/{appId}")
	public Document addDoc(@RequestBody Document doc) {
	    return service.addDocument(doc);
	}
	 
	@PutMapping("/{docId}")
	public Document updateDoc(@PathVariable Long docId, @RequestBody Document doc) {
	    return service.updateDocument(docId, doc);
	}
	 
	@DeleteMapping("/{docId}")
	public void deleteDoc(@PathVariable Long docId) {
	    service.deleteDocument(docId);
	}
}
