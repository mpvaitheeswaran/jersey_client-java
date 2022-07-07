package com.vaitheeswaran.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class App 
{
    public static void main( String[] args )
    {
        String url = "http://localhost:8080/restapi/rest/";
        
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        WebTarget studentWebTarget = webTarget.path("students/{rollno}");
        WebTarget studentPostTarget = webTarget.path("students/add");
        Student student = studentWebTarget.resolveTemplate("rollno", "101")
        		.request(MediaType.APPLICATION_JSON)
        		.get(Student.class);
        Student newStudent = new Student(104,"Kamala","Yong avengers",16);
        Response postStudent = studentPostTarget        		
        		.request(MediaType.APPLICATION_JSON)
        		.post(Entity.json(newStudent));
        		
        Student addedStudent = postStudent.readEntity(Student.class);
        
//        Invocation.Builder invocationBuilder =  studentWebTarget.request(MediaType.APPLICATION_JSON);
//        Student student = invocationBuilder.get(Student.class);
         
//        Student student = response.readEntity(Student.class);
//           
//        System.out.println(response.getStatus());
        System.out.println(student);
    }
}
