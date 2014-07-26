package com.example.rest.data;

import com.example.rest.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    private List<Person> persons = new ArrayList<Person>();


    public PersonDao() {
      persons.add(new Person(1, "Edwin", "Biemond"));
      persons.add(new Person(2, "Mark", "Nelson"));
    }
    
    public List<Person> findAll(){
       return this.persons; 
    }

    public Person findPerson(Integer id) throws PersonNotFoundException {
       for ( Person person : this.persons) {
           if ( person.getId() != null && person.getId() == id ) {
             return person;
           }
       }
       throw new PersonNotFoundException(); 
    }
}

