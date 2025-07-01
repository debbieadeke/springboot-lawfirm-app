package com.lawfirm.lawfirm.repositories;

import com.lawfirm.lawfirm.models.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
}
