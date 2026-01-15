package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.transtu.intranet.entity.Document;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	List<Document> findByApplicationId(Long applicationId);
}
