package com.vaitheeswaran.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	 private static final String REST_URI = "http://localhost:8080/restapi/rest/";
	 private Client client = ClientBuilder.newClient();

	 public Student getStudent(int rollno) {
		 return client
		          .target(REST_URI)
		          .path("students/{rollno}")
		          .resolveTemplate("rollno", rollno)
		          .request(MediaType.APPLICATION_JSON)
		          .get(Student.class);
	 }
	 
	 public Response createStudent(Student newStudent) {
		    return client
		      .target(REST_URI)
		      .path("students/add")
		      .request(MediaType.APPLICATION_JSON)
		      .post(Entity.entity(newStudent, MediaType.APPLICATION_JSON));
	 }
	 
	 public List<Student> getAllStudents(){
		 return client
				 .target(REST_URI)
				 .path("students")
                 .request(MediaType.APPLICATION_JSON)
                 .get(Response.class)
                 .readEntity(new GenericType<List<Student>>() {});
	 }
}
