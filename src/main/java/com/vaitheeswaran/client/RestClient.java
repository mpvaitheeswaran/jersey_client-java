package com.vaitheeswaran.client;

import java.io.File;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

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
	 
	 public Response postFile(File uploadFile) {
		Client client = ClientBuilder.newBuilder().
                 register(MultiPartFeature.class).build();
		WebTarget server = client.target(REST_URI).path("students/upload");
		MultiPart multiPart = new MultiPart();
		FileDataBodyPart fileBodyPart = new FileDataBodyPart("file", uploadFile,
                MediaType.APPLICATION_OCTET_STREAM_TYPE);
		multiPart.bodyPart(fileBodyPart);
		
		Response response = server.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(multiPart,MediaType.MULTIPART_FORM_DATA));
        if (response.getStatus() == 200) {
            String respnse = response.readEntity(String.class);
            System.out.println(respnse);
        } else {
            System.out.println("Response is not ok");
        }
		
		return response;
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
