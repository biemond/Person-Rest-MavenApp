package test.com.example.rest.services;

import com.example.rest.data.PersonDao;
import com.example.rest.data.PersonNotFoundException;
import com.example.rest.entities.Person;
import com.example.rest.services.PersonResource;

import java.util.ArrayList;
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
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonResourceMockTest  extends JerseyTest {
    public PersonResourceMockTest() {
    }


    private PersonDao personDao;

    @Override
    protected Application configure(){
        PersonResource personResource = new PersonResource();
        personDao = mock(PersonDao.class);
        personResource.setPersonDao(personDao);
        return new ResourceConfig().registerInstances(personResource);
    }

    @Test
    public void findAll() {

      List<Person> mockPersons = new ArrayList<Person>();
      mockPersons.add(new Person(1,"John","Doe"));
        
      when(personDao.findAll()).thenReturn(mockPersons);

      Response result = target("person").request()
                                        .accept(MediaType.APPLICATION_JSON)
                                        .get(Response.class);

      if(result.getStatus() != Response.Status.OK.getStatusCode()){
        fail("Wrong status code "+result.getStatus());   
      }    

      verify(personDao).findAll();
      
      List<Person> persons =  result.readEntity(new GenericType<List<Person>>(){});

      assertEquals(1,persons.size());
      for ( Person person : persons) {
         assertNotNull(person.getId());
         if ( person.getId() == 1 ) {
            assertEquals("John",person.getFirstName()); 
         }
      }       
    }

    @Test
    public void findPerson() throws PersonNotFoundException {

      Integer id = 10;
      Person mockPerson = new Person(id,"John","Doe");
      
      when(personDao.findPerson(id)).thenReturn(mockPerson);


      final Response result = target("person/"+id).request()
                                                  .accept(MediaType.APPLICATION_JSON)
                                                  .get(Response.class);

      verify(personDao).findPerson(id);

      if(result.getStatus() != Response.Status.OK.getStatusCode()){
        fail("Wrong status code "+result.getStatus());   
      }    
      
      Person person = result.readEntity(new GenericType<Person>(){});
      assertEquals("John",person.getFirstName()); 
    }

}
