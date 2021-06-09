package com.aoslec.networkjson;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class JsonMember {

    // property
    // parsing 할 것이기에 순서는 상관 없고 속성(string, int)만 주의해서 사용하기
    private String name;
    private int age;
    private ArrayList<String> hobbies;
    private int no;
    private String id;
    private String pw;

    // constructor
    public JsonMember(String name, int age, ArrayList<String> hobbies, int no, String id, String pw) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.no = no;
        this.id = id;
        this.pw = pw;
    }

    // method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
