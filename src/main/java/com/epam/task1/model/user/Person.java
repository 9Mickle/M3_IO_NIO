package com.epam.task1.model.user;

import java.io.Serializable;

/**
 * Человек.
 */
public class Person implements Serializable{

    private String name;
    private  transient Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
