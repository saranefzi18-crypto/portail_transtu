package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.transtu.intranet.entity.DocumentEntity;

import java.util.List;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
	List<DocumentEntity> findByApplicationId(Long applicationId);
}
