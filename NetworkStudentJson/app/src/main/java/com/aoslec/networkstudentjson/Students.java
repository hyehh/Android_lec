package com.aoslec.networkstudentjson;

public class Students {

    // property
    private String code;
    private String name = null;
    private String dept = null;
    private String phone = null;

    // constructor
    public Students(String code, String name, String dept, String phone) {
        this.code = code;
        this.name = name;
        this.dept = dept;
        this.phone = phone;
    }

    // method
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
