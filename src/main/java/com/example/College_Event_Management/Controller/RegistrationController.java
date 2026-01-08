package com.example.College_Event_Management.Controller;

import com.example.College_Event_Management.Model.Registration;
import com.example.College_Event_Management.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @GetMapping("/all-registration")
    public List<Registration> getRegistration() {
        return registrationService.getRegistration();
    }

    @GetMapping("/{Id}")
    public List<Registration> getEventRegistration(@PathVariable Long Id) {
        return registrationService.getEventRegistration(Id);
    }

    @GetMapping("/student/{Id}")
    public List<Registration> getStudentRegistration(@PathVariable Long Id){
        return registrationService.getStudentRegistration(Id);
    }

    @PostMapping("/register")
    public Registration registerStudent(@RequestParam Long studentId, @RequestParam Long eventId) throws Exception {
        return registrationService.registerStudent(studentId,eventId);
    }

    @PutMapping("/attend/{Id}")
    public Registration markAttendence(@PathVariable Long Id){
        return registrationService.markAttendence(Id);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelStudent(@RequestParam Long studentId, @RequestParam Long eventId){
        return registrationService.cancelStudent(studentId,eventId);
    }
}
