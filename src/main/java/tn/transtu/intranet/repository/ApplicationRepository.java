package tn.transtu.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.transtu.intranet.entity.Application;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	    List<Application> findByStatus(String status);
}
