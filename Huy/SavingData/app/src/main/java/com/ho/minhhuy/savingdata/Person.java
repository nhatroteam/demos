package com.ho.minhhuy.savingdata;

/**
 * Created by Hi on 3/24/2016.
 */
public class Person {
    private String name;
    private String age;
    private String image;

    public Person() {
    }

    public Person(String age,  String name) {
        this.age = age;

        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}