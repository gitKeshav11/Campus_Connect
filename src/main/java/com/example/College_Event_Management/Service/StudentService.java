package com.example.College_Event_Management.Service;

import com.example.College_Event_Management.Model.Student;
import com.example.College_Event_Management.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeById(Long Id) {
        if(studentRepository.existsById(Id))
            studentRepository.deleteById(Id);
        else{
            System.out.println("Student not found...!");
        }
    }

    public Optional<Student> fetchStuByName(String name) {
        return studentRepository.findByName(name);
    }
}
