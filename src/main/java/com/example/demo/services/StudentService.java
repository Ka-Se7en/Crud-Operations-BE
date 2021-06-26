package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getData(){
        studentRepository.save(new Student("alper","seven"));
        studentRepository.save(new Student("alperen","cerezci"));
        List<Student> student = new ArrayList<Student>();
        studentRepository.findAll().forEach(student1 -> student.add(student1));
        return student;
    }

    public String deleteById(long id){
        if (studentRepository.findById(id) != null) {
            studentRepository.deleteById(id);
            return "Başarılı";
        }
        return "Başarısız";
    }
}
