package com.example.rest.entities;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Person {
    public Person() {
    }


    public Person(Integer id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    private Integer id;
    private String firstName;
    private String lastName;
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

}