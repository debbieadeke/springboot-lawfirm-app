package com.lawfirm.lawfirm.repository;

import com.lawfirm.lawfirm.models.Hearing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HearingRepository extends JpaRepository<Hearing, Long> {
}
