package com.example.College_Event_Management.Controller;

import com.example.College_Event_Management.Model.Student;
import com.example.College_Event_Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/fetch")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/fetch/{name}")
    public Optional<Student> fetchStuByName(@PathVariable String name){
        return studentService.fetchStuByName(name);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/remove/{Id}")
    public void removeById(@PathVariable Long Id){
        studentService.removeById(Id);
    }
}
