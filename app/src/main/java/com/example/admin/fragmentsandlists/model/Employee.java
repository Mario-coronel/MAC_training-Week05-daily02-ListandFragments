package com.example.admin.fragmentsandlists.model;

public class Employee {

   private String name,position,location, gender;

    public Employee() {

    }

    public Employee(String name, String position, String location, String gender) {
        this.name = name;
        this.position = position;
        this.location = location;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
