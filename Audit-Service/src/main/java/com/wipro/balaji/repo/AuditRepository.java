package com.wipro.balaji.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.balaji.entity.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long>{

}
