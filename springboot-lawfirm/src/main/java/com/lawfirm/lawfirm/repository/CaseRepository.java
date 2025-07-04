package com.lawfirm.lawfirm.repository;


import com.lawfirm.lawfirm.models.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<LegalCase, Long> {
}
