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
public class District {

    public District() {}

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private String ilce_id;
    private String ilce_title;
    private String ilce_key;
    private String ilce_sehirkey;

    public String getIlce_id() {
        return ilce_id;
    }

    public void setIlce_id(String ilce_id) {
        this.ilce_id = ilce_id;
    }

    public String getIlce_title() {
        return ilce_title;
    }

    public void setIlce_title(String ilce_title) {
        this.ilce_title = ilce_title;
    }

    public String getIlce_key() {
        return ilce_key;
    }

    public void setIlce_key(String ilce_key) {
        this.ilce_key = ilce_key;
    }

    public String getIlce_sehirkey() {
        return ilce_sehirkey;
    }

    public void setIlce_sehirkey(String ilce_sehirkey) {
        this.ilce_sehirkey = ilce_sehirkey;
    }
}

