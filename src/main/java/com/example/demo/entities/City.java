package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class City {

    public City() {}

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private String sehir_id;
    private String sehir_title;
    private String sehir_key;

    public String getSehir_id() {
        return sehir_id;
    }

    public void setSehir_id(String sehir_id) {
        this.sehir_id = sehir_id;
    }

    public String getSehir_title() {
        return sehir_title;
    }

    public void setSehir_title(String sehir_title) {
        this.sehir_title = sehir_title;
    }

    public String getSehir_key() {
        return sehir_key;
    }

    public void setSehir_key(String sehir_key) {
        this.sehir_key = sehir_key;
    }
}
