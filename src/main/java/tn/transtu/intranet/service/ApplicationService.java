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
	
}
