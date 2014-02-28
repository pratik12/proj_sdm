package com.sdm.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdm.DAO.DoctorDAO;
import com.sdm.DAO.UserDAO;
import com.sdm.model.Doctor;



public class DoctorAction extends ActionSupport 
			implements ModelDriven<Doctor>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 Doctor doctor  = new Doctor();
	   List<Doctor> doctors = new ArrayList<Doctor>();
	   UserDAO userDAO = new UserDAO();
	   DoctorDAO doctorDAO = new DoctorDAO();
	
	public Doctor getModel() {
		return doctor;
	}
	
	 public String addDoctor()
	   {
		 System.out.println("*********");
		 System.out.println(doctor.getDoctorId());
		 System.out.println(doctor.getDoctorName());
		 
		 
		 System.out.println(doctor.getUser().getUserId());
		 System.out.println(doctor.getUser().getPassword());
		 
		 doctor.setStatus("Active");
		 doctor.getUser().setAccessLevel("Doctor");
		 userDAO.addUser(doctor.getUser());
		 doctorDAO.addDoctor(doctor);
	     
	     
	      return "success";
	   }

		

}
