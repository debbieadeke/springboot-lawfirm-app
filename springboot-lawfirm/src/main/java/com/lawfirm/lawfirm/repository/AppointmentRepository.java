package com.lawfirm.lawfirm.repository;

import com.lawfirm.lawfirm.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
// This interface extends JpaRepository, which provides CRUD operations for the Appointment entity.