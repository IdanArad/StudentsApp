package com.example.assignment4studentsapp.model;

public class Student {
    String name;
    String id;
    String phone;
    String address;
    boolean isChecked;

    public Student() {
        this.name = "";
        this.id = "";
        this.phone = "";
        this.address = "";
        this.isChecked = false;
    }

    public Student(String name, String id, String phone, String address, boolean checked) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.isChecked = checked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public boolean isChecked() {
        return isChecked;
    }
}
