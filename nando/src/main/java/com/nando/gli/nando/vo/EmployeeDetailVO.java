package com.nando.gli.nando.vo;

public class EmployeeDetailVO {

    private String fullName;
    private String address;
    private String dob;
    private Integer roleId;
    private Integer salary;

    public EmployeeDetailVO() {
    }

    public EmployeeDetailVO(String fullName, String address, String dob, Integer roleId, Integer salary) {
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.roleId = roleId;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


}
