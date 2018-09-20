package com.potatosaucevfx.springbootsandbox.model;

import java.util.Date;

/**
 *
 * @author Richard Nader Jr. <heelyskidrj@gmail.com>
 */
public class Person {

    private String name;
    private String occupation;
    private String location;
    private int extention;
    private String startDate;
    private String salary;

    public Person() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getExtention() {
        return extention;
    }

    public void setExtention(int extention) {
        this.extention = extention;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
