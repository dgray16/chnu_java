package com.javafxmvc.model.entity;


import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Administrator on 22.02.2015.
 */
public class Student {
    private int         id;
    private String      name;
    private String      group;
    private String      department;
    private LocalDate date;

    public Student(int id, String name, String group, String department, LocalDate date){
        this.id = id;
        this.name = name;
        this.group = group;
        this.department = department;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
