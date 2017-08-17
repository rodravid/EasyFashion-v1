package com.experience.totvs.easyfashion_v1.domain.user;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String style;

    public User() {

    }

    public User(String name, int age, String gender, String style) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public User setStyle(String style) {
        this.style = style;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s - Style: %s", name, style);
    }
}
