package tn.transtu.intranet.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Document {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long applicationId;
    private String title;
    private String type;
    private String url;
    private LocalDateTime updatedAt;
    private Application application;
    
    public Document() {
    }
    
    public  Document(Long applicationId, String title, String type, String url, LocalDateTime updatedAt, Application application) {
    	this.applicationId=applicationId;
    	this.title=title;
    	this.type=type;
    	this.url=url;
    	this.updatedAt=updatedAt;
    	this.application=application;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
    void onCreate() {
        updatedAt = LocalDateTime.now();
    }
	
	public void setApplication(Application application) { 
		this.application = application; }

}
