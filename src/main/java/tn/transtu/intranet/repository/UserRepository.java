package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.transtu.intranet.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
