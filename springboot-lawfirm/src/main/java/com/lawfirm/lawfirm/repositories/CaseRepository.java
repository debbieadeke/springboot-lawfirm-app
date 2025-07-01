package com.lawfirm.lawfirm.repositories;

import com.lawfirm.lawfirm.models.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
