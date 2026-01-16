package tn.transtu.intranet.service;

import org.springframework.stereotype.Service;

import tn.transtu.intranet.entity.Application;
import tn.transtu.intranet.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {
	private final ApplicationRepository repository;
	
	public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }
	
	public List<Application> getAllActive() {
        return repository.findByStatus("ACTIVE");
    }
	
	public Application getById(Long id) {
	    Application app = repository.findById(id).orElse(null); 
	    if (app == null) {
	        throw new RuntimeException("Application not found");
	    }
	    return app;
	}
	
	public Application create(Application app) {
        return repository.save(app);
    }
	
	public Application update(Long id, Application app) {
		Application app1 = repository.findById(id).orElseThrow();
		app1.setCode(app.getCode());
		app1.setTitle(app.getTitle());
		app1.setCategory(app.getCategory());
		app1.setDescription(app.getDescription());
		app1.setAccessUrl(app.getAccessUrl());
		app1.setUnits(app.getUnits());
		app1.setActiveUsers(app.getActiveUsers());
		app1.setAudience(app.getAudience());
		app1.setSupportContact(app.getSupportContact());
		app1.setDevelopedBy(app.getDevelopedBy());
		app1.setMaintainedBy(app.getMaintainedBy());
		app1.setOwnerBusiness(app.getOwnerBusiness());
		app1.setOwnerTechnical(app.getOwnerTechnical());
		app1.setStatus(app.getStatus());

		return repository.save(app1);
	}
	public Application changeStatus(Long id, String status) {
	    Application app = repository.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
	    app.setStatus(status);
	    return repository.save(app);
	}
	
	
	
}
