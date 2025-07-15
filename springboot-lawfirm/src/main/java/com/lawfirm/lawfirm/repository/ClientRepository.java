// package com.lawfirm.lawfirm.repository;

// import com.lawfirm.lawfirm.models.Client;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface ClientRepository extends JpaRepository<Client, Long> {
// }
package com.lawfirm.lawfirm.repository;

import com.lawfirm.lawfirm.models.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
    String firstName, String lastName);
}
