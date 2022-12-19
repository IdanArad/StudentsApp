package com.example.assignment4studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model() {
        for (int i = 0; i < 20; i++) {
            Student s = new Student("name " + i, "id " + i, "" + i, "21 street " + i, false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public Student getStudent(int position) {
        return data.get(position);
    }

    public void addStudent(Student student) {
        data.add(student);
    }

    public void removeStudent(int position) {
        data.remove(position);
    }
}
