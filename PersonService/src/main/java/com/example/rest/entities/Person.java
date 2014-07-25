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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        final Person other = (Person) object;
        if (!(id == null ? other.id == null : id.equals(other.id))) {
            return false;
        }
        if (!(firstName == null ? other.firstName == null : firstName.equals(other.firstName))) {
            return false;
        }
        if (!(lastName == null ? other.lastName == null : lastName.equals(other.lastName))) {
            return false;
        }
        return true;
    }

}