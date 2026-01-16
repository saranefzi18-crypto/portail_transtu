package tn.transtu.intranet.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.transtu.intranet.entity.Application;
import tn.transtu.intranet.service.ApplicationService;

@RestController
@RequestMapping("/api/admin/apps")
public class AdminApplicationController {
	private final ApplicationService service;
	
	public AdminApplicationController(ApplicationService service) {
        this.service = service;
    }
	
	@PostMapping
    public Application createApp(@RequestBody Application app) {
        return service.create(app);
    }
	
	@PutMapping("/{id}")
    public Application updateApp(@PathVariable Long id, @RequestBody Application app) {
        return service.update(id, app);
    }
	
	@PatchMapping("/{id}/status")
    public Application changeStatus(@PathVariable Long id, @RequestParam String status) {
        return service.changeStatus(id, status);
    }
	
	

}
