package tn.transtu.intranet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApplicationEntity {
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
