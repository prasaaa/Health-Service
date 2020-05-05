package com;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.DoctorM;

@Path("Doctor")
public class Doctor {
	
	DoctorRepositry repo = new DoctorRepositry();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<DoctorM> getDoctors()
	 {
		System.out.println("Get Doctor..");
		return repo.getDoctors();
	 } 
	
	@GET
	@Path("Doctor/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DoctorM getDoctor(@PathParam("id")int id)
	 {
		
		return repo.getDoctor(id);
	 } 
	
	@POST
	@Path("Doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public DoctorM createDoctor(DoctorM d1) {
		System.out.println(d1);
		repo.create(d1);
		return d1;
	}
	
	@PUT
	@Path("Doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DoctorM updateDoctor(DoctorM d1) {
		System.out.println(d1);
		if(repo.getDoctor(d1.getId()).getId()==0) {
			System.out.println("Inavlide ID");
		}
		repo.update(d1);
		return d1;
	}
	
	

}
