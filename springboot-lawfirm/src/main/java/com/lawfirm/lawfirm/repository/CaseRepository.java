package com.lawfirm.lawfirm.repository;


import com.lawfirm.lawfirm.models.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CaseRepository extends JpaRepository<LegalCase, Long> {

    @Query("""
        SELECT c FROM LegalCase c
        WHERE LOWER(c.caseDetails) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(CONCAT(c.client.firstName, ' ', c.client.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(CONCAT(c.lawyer.firstName, ' ', c.lawyer.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<LegalCase> searchByKeyword(@Param("keyword") String keyword);
}
