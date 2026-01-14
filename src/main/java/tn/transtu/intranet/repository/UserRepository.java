package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.transtu.intranet.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByUsername(String username);
}
