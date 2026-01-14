package tn.transtu.intranet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DocumentEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long applicationId;

    private String title;

    private String type;
    private String url;
    private LocalDateTime updatedAt;
    @PrePersist
    void onCreate() {
        updatedAt = LocalDateTime.now();
    }

}
