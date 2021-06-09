package com.aoslec.networkstudentwebviewjson;

public class Pets {

    // Property
    private String name = null;
    private int age = 0;
    private String gender = null;
    private String images = null;

    // Constructor
    public Pets(String name, int age, String gender, String images) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.images = images;
    }

    // Method
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
