package com.example.akashsalow.project.Bean;

import java.io.Serializable;

/**
 * Created by Akash Salow on 11-06-2017.
 */

public class Registration implements Serializable {
    private String name;
    private Integer phoneNumber;
    private String unit;
    private String technology;
    private String dc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", unit='" + unit + '\'' +
                ", technology='" + technology + '\'' +
                ", dc='" + dc + '\'' +
                '}';
    }
}
