package com.example.College_Event_Management.Repository;

import com.example.College_Event_Management.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<Registration> findStudentById(Long id);

    List<Registration> findEventById(Long id);

    void delete(Registration existRegistration);


    Optional<Registration> findByStudentIdAndEventId(Long studentId, Long eventId);
}
