// package com.lawfirm.lawfirm.repository;

// import com.lawfirm.lawfirm.models.Lawyer;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
// }
package com.lawfirm.lawfirm.repository;


import com.lawfirm.lawfirm.models.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

List<Lawyer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrBarNumberContainingIgnoreCase(
    String firstName, String lastName, String barNumber);
}
