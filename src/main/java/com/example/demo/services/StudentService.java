package com.example.demo.services;

import aj.org.objectweb.asm.TypeReference;
import com.example.demo.entities.City;
import com.example.demo.entities.District;
import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private static List<City> cityList = null;
    private static List<District> districtList = null;

    public List<Student> getDefaultData(){
        studentRepository.save(new Student("alper","seven"));
        studentRepository.save(new Student("alperen","cerezci"));
        List<Student> student = new ArrayList<Student>();
        studentRepository.findAll().forEach(student1 -> student.add(student1));
        return student;
    }

    public List<Student> getList() {
        List<Student> student = new ArrayList<Student>();
        studentRepository.findAll().forEach(studentItem -> {
            student.add(studentItem);
        });
        if (student.size() > 0) {
            return student;
        }
        return getDefaultData();
    }

    public List<Student> getStudentFromById(long id){
        List<Student> student = new ArrayList<Student>();
        if (studentRepository.findById(id) != null) {
            Student studentItem = studentRepository.findById(id).get();
            student.add(studentItem);
        }
        return student;
    }

    public String getDistrictName(String districtKey){
        String res = "";
        for (int i = 0; i < districtList.size(); i++){
            if (districtList.get(i).getIlce_key().equals(districtKey)) {
                res = districtList.get(i).getIlce_title();
            }
        }
        return res;
    }

    public String getCityName(String cityKey){
        String res = "";
        for (int i = 0; i < cityList.size(); i++){
            if (cityList.get(i).getSehir_key().equals(cityKey)) {
                res = cityList.get(i).getSehir_title();
            }
        }
        return res;
    }

    public boolean save(Student body){
        try {
            body.setCityName(getCityName(body.getCityKey()));
            body.setDistrictName(getDistrictName(body.getDistrictKey()));
            studentRepository.save(body);

            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean deleteById(long id){
        if (studentRepository.findById(id) != null) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<City> cityGetList(){
        if (cityList == null || !(cityList.size() > 0)) {
            fillDataCityList();
        }
        return cityList;
    }

    public List<District> getListByCityKey(String id) {
        if (districtList == null || !(districtList.size() > 0)) {
            fillDataDistrictList();
        }
        List<District> resList = new ArrayList<District>();
        for (int i = 0; i < districtList.size(); i++) {
            if (districtList.get(i).getIlce_sehirkey().equals(id)) {
                resList.add(districtList.get(i));
            }
        }
        return resList;
    }

    public void fillDataCityList() {
        ObjectMapper mapper = new ObjectMapper();
        com.fasterxml.jackson.core.type.TypeReference<List<City>> typeReference = new com.fasterxml.jackson.core.type.TypeReference<List<City>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/city.json");
        try {
            cityList = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            System.out.println("There is one probelem.. : " + e);
        }
    }

    public void fillDataDistrictList() {
        ObjectMapper mapper = new ObjectMapper();
        com.fasterxml.jackson.core.type.TypeReference<List<District>> typeReference = new com.fasterxml.jackson.core.type.TypeReference<List<District>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/district.json");
        try {
            districtList = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            System.out.println("There is one problem.. : " + e);
        } finally {
        }
    }
}
