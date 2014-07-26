package com.example.rest.services;

import com.example.rest.data.PersonDao;
import com.example.rest.data.PersonNotFoundException;
import com.example.rest.entities.Person;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("person")
@Consumes("application/json")
@Produces("application/json")
public class PersonResource {
    public PersonResource() {
    }

    PersonDao personDao = new PersonDao();

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GET
    public Response getPersons() {
        List<Person> persons = personDao.findAll();
        return Response.ok(persons.toArray(new Person[persons.size()])).build();
    }

    @GET
    @Path("/{id}")
    public Response getPerson(@PathParam("id") Integer id) {
        try {
            Person person = personDao.findPerson(id);
            return Response.ok(person).build();
        } catch (PersonNotFoundException e) {
           return Response.status(Response.Status.NOT_FOUND).build(); 
        }
    }
}
