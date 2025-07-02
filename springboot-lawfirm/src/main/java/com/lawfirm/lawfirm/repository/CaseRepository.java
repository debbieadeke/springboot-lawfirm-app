package com.lawfirm.lawfirm.repository;


import com.lawfirm.lawfirm.models.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
}
