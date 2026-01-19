package tn.transtu.intranet.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Document {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private String url;
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;
    
    public Document() {}
    
    public  Document(String title, String type, String url, LocalDateTime updatedAt, Application application) {
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
