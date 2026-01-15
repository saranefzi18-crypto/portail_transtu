package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.transtu.intranet.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
}
