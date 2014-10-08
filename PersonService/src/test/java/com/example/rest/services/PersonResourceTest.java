package com.example.rest.services;

import com.example.rest.entities.Person;
import com.example.rest.services.PersonResource;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;


public class PersonResourceTest  extends JerseyTest {
    public PersonResourceTest() {
    }

    @Override
    protected Application configure(){
        return new ResourceConfig(PersonResource.class);
    }

    @Test
    public void findAll() {
      final Response result = target("person").request()
                                              .accept(MediaType.APPLICATION_JSON)
                                              .get(Response.class);

      if(result.getStatus() != Response.Status.OK.getStatusCode()){
        fail("Wrong status code "+result.getStatus());
      }

      List<Person> persons =  result.readEntity(new GenericType<List<Person>>(){});

      assertEquals(2,persons.size());

      for ( Person person : persons) {
          assertNotNull(person.getId());
          if ( person.getId() == 1 ) {
              assertEquals("Edwin",person.getFirstName());
          }
          if ( person.getId() == 2 ) {
              assertEquals("Mark",person.getFirstName());
          }
       }
    }

    @Test
    public void findPerson() {
      final Response result = target("person/1").request()
                                              .accept(MediaType.APPLICATION_JSON)
                                              .get(Response.class);

      if(result.getStatus() != Response.Status.OK.getStatusCode()){
        fail("Wrong status code "+result.getStatus());
      }

      Person person = result.readEntity(new GenericType<Person>(){});
      assertEquals("Edwin",person.getFirstName());
    }

    @Test
    public void findPersonNotfound() {
      final Response result = target("person/100").request()
                                              .accept(MediaType.APPLICATION_JSON)
                                              .get(Response.class);

      assertEquals(result.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

}
