package tn.transtu.intranet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.transtu.intranet.entity.Application;
import tn.transtu.intranet.service.ApplicationService;

@RestController
@RequestMapping("/api/apps")

public class ApplicationController {
	private final ApplicationService service;
	
	public ApplicationController(ApplicationService service) {
        this.service = service;
    }
	
	@GetMapping
    public List<Application> getAll() {
        return service.getAllActive();
    }
	
	@GetMapping("/{id}")
    public Application getById(@PathVariable Long id) {
        return service.getById(id);
    }
	

}
