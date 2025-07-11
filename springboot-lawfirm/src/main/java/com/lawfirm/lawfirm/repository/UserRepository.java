package com.lawfirm.lawfirm.repository;

import com.lawfirm.lawfirm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
