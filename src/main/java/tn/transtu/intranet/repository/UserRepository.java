package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.transtu.intranet.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUsername(String username);
}
