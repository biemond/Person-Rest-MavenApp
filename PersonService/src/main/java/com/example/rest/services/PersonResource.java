package com.example.rest.services;

import com.example.rest.entities.Person;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("person")
@Consumes("application/json")
@Produces("application/json")
public class PersonResource {
    public PersonResource() {
    }

    @GET
    public Response getPersons() {
        List<Person> persons = getMockData();
        return Response.ok(persons.toArray(new Person[persons.size()])).build();
    }

    private List<Person> getMockData() {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "Edwin", "Biemond"));
        persons.add(new Person(2, "Mark", "Nelson"));

        return persons;

    }

}
