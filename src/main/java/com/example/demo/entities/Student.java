package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {

    public Student(){}

    public Student(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictKey() {
        return districtKey;
    }

    public void setDistrictKey(String districtKey) {
        this.districtKey = districtKey;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "CITY_KEY")
    private String cityKey;
    @Column(name = "CITY_NAME")
    private String cityName;
    @Column(name = "DISTRICT_KEY")
    private String districtKey;
    @Column(name = "DISTRICT_NAME")
    private String districtName;
    @Column(name = "DESCRIPTION")
    private String description;
}
