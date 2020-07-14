package com.nando.gli.nando.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeVO {

    private String fullName;

    private String dob;

    private Integer salary;

    public EmployeeVO() {
    }

    public EmployeeVO(String fullName, String dob, Integer salary) {
        this.fullName = fullName;
        this.dob = dob;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
