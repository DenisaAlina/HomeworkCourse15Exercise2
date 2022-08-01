package com.fasttrackit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Integer age;
    private String name;
    private Integer id;

    public Person(Integer age, String name) {
        if (name == null || age<0 || age>120){
            throw new RuntimeException();
        }
        this.age = age;
        this.name = name;
    }
}
