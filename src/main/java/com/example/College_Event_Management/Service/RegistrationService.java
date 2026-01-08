package com.example.College_Event_Management.Service;

import com.example.College_Event_Management.Model.Event;
import com.example.College_Event_Management.Model.Registration;
import com.example.College_Event_Management.Model.Student;
import com.example.College_Event_Management.Repository.EventRepository;
import com.example.College_Event_Management.Repository.RegistrationRepository;
import com.example.College_Event_Management.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Registration> getRegistration() {
        return registrationRepository.findAll();
    }

    public Registration registerStudent(Long studentId, Long eventId) throws Exception {

        Student existStudent = studentRepository.findById(studentId).orElseThrow();
        Event existEvent = eventRepository.findById(eventId).orElseThrow();
        Optional<Registration> existing = registrationRepository.findByStudentIdAndEventId(studentId, eventId);

        if (existing.isPresent()) {
            System.out.println("Student already registered...!");
        }

        Registration register = new Registration();
        register.setStudent(existStudent);
        register.setEvent(existEvent);
        register.setAttended(false);
        return registrationRepository.save(register);
    }

    public List<Registration> getStudentRegistration(Long Id) {
        return registrationRepository.findStudentById(Id);
    }

    public List<Registration> getEventRegistration(Long Id) {
        return registrationRepository.findEventById(Id);
    }

    public ResponseEntity<String> cancelStudent(Long studentId, Long eventId) {
        Optional<Registration> registrationOpt = registrationRepository.findByStudentIdAndEventId(studentId, eventId);

        if (registrationOpt.isPresent()) {
            registrationRepository.delete(registrationOpt.get());
            return ResponseEntity.ok("Registration deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Registration not found for given student and event.");
        }
    }

    public Registration markAttendence(Long Id) {
        Registration registered = registrationRepository.findById(Id).orElseThrow();
        registered.setAttended(true);
        return registrationRepository.save(registered);
    }
}
