package com.example.demo.controller;

import com.example.demo.entities.City;
import com.example.demo.entities.District;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getList")
    public List<Student> getList() {
        return studentService.getList();
    }

    @GetMapping("/getStudentById/{id}")
    public List<Student> getStudentFromById(@PathVariable("id") long id) {
        return studentService.getStudentFromById(id);
    }

    @PostMapping("/addStudent")
    public boolean addStudent(@RequestBody Student body) {
        if (body != null) {
            return studentService.save(body);
        }
        return false;
    }

    @PutMapping("/updateStudent")
    public boolean updateStudent(@RequestBody Student body) {
        if (body != null) {
            return studentService.save(body);
        }
        return false;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id) {
        if (id > 0) {
            return studentService.deleteById(id);
        }

        return false;
    }

    @GetMapping("/city/getList")
    public List<City> cityGetList(){
        return studentService.cityGetList();
    }

    @GetMapping("district/getListByCityKey/{id}")
    public List<District> getListByCityKey(@PathVariable("id") String id) {
        return studentService.getListByCityKey(id);
    }
}
