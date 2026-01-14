package tn.transtu.intranet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(unique = true, nullable = false)
    private String username;
	@Column(nullable = false)
    private String passwordHash;
	private String role;

}
