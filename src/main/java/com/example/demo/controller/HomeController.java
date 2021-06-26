package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("home/getData")
    public List<Student> getData(){
        return studentService.getData();
    }

    @DeleteMapping("home/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        return studentService.deleteById(id);
    }
}
