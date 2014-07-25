package test.com.example.rest.services;

import com.example.rest.entities.Person;
import com.example.rest.services.PersonResource;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Assert;
import org.junit.Test;


public class PersonResourceTest  extends JerseyTest {
    public PersonResourceTest() {
    }

    @Override
    protected Application configure(){
        return new ResourceConfig(PersonResource.class);
    }

    @Test
    public void test() {
      final Response result  =  target("person").request().accept(MediaType.APPLICATION_JSON).get(Response.class);
      if(result.getStatus() != Response.Status.OK.getStatusCode()){
        Assert.fail("Wrong status code "+result.getStatus());   
      }    
      
      List<Person> persons =  result.readEntity(new GenericType<List<Person>>() {});
      Assert.assertEquals(2,persons.size());
    }

}
