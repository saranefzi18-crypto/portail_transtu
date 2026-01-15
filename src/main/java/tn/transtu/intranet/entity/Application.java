package tn.transtu.intranet.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
    private String code;
	@Column(nullable = false)
	private String title;
	private String category;
	@Column(length = 500)
    private String description;
    private String accessUrl;
    private String units;
    private Integer activeUsers;
    private String audience;
    private String supportContact;
    @Column(nullable = false)
    private String developedBy;
    @Column(nullable = false)
    private String maintainedBy;
    private String ownerBusiness;
    private String ownerTechnical;
    private String status= "ACTIVE";
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Application() {}
    
    public Application(String code, String title, String category, String description,String accessUrl, String units, Integer activeUsers, String audience, String supportContact,String developedBy, String maintainedBy, String ownerBusiness, String ownerTechnical,String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.code = code;
        this.title = title;
        this.category = category;
        this.description = description;
        this.accessUrl = accessUrl;
        this.units = units;
        this.activeUsers = activeUsers;
        this.audience = audience;
        this.supportContact = supportContact;
        this.developedBy = developedBy;
        this.maintainedBy = maintainedBy;
        this.ownerBusiness = ownerBusiness;
        this.ownerTechnical = ownerTechnical;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}

	public Integer getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(Integer activeUsers) {
		this.activeUsers = activeUsers;
	}
	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public String getSupportContact() {
		return supportContact;
	}

	public void setSupportContact(String supportContact) {
		this.supportContact = supportContact;
	}

	public String getDevelopedBy() {
		return developedBy;
	}

	public void setDevelopedBy(String developedBy) {
		this.developedBy = developedBy;
	}

	public String getMaintainedBy() {
		return maintainedBy;
	}

	public void setMaintainedBy(String maintainedBy) {
		this.maintainedBy = maintainedBy;
	}

	public String getOwnerBusiness() {
		return ownerBusiness;
	}

	public void setOwnerBusiness(String ownerBusiness) {
		this.ownerBusiness = ownerBusiness;
	}

	public String getOwnerTechnical() {
		return ownerTechnical;
	}

	public void setOwnerTechnical(String ownerTechnical) {
		this.ownerTechnical = ownerTechnical;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	@PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
