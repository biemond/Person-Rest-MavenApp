#Restful Person Test project

##Urls
- WADL,        /PersonService-1.0-SNAPSHOT/resources/application.wadl
- All persons, /PersonService-1.0-SNAPSHOT/resources/person
- One person,  /PersonService-1.0-SNAPSHOT/resources/person/1

##Build
- JDeveloper 12.1.3 application but has the default Maven folder layout
- Tested with Maven 3.0.5 

##Maven Test
- Test RestService with JerseyTest ( on a grizzly2 webserver )
- Test RestService with JerseyTest and mock the data with Mockito
- soapUI with TestSuite ( after deploy )
  - Check response codes
  - SLA
  - Output

##Maven Deploy
- Uses the WebLogic plugin to deploy against the integrated JDeveloper WebLogic server

##Requires
- Oracle Maven sync plugin to fill your local or remote repository with Oracle artifacts
- Smartbear maven repository http://www.soapui.org/repository/maven2/