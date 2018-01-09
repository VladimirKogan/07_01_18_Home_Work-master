package com.example.vladik.a07_01_18_home_work;

/**
 * Created by vladimir on 08/01/2018.
 */

public class Person {
    private String name, phone, email, description;

    public Person(String name, String phone, String email, String description) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "," + phone + "," + email + "," + description + ";";
    }

    public static Person newInstance(String str){
        String[] arr = (str.substring(0, str.length()-1)).split(",");
        Person person = new Person(arr[0], arr[1], arr[2], arr[3]);
        return person;
    }
}
