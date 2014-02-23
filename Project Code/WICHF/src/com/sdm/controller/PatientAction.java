package com.sdm.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdm.DAO.PatientDAO;
import com.sdm.DAO.UserDAO;
import com.sdm.model.Patient;

public class PatientAction extends ActionSupport implements ModelDriven<Patient> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Patient patient = new Patient();
	UserDAO userDAO = new UserDAO();
	PatientDAO patientDAO = new PatientDAO();

	public Patient getModel() {
		return patient;
	}

	
	public String addPatient() {
		System.out.println("*********");
		System.out.println(patient.getUser().getUserId());
		System.out.println(patient.getUser().getPassword());
		System.out.println(patient.getBirthDate()); 
		
		patient.getUser().setAccessLevel("patient");
		userDAO.addUser(patient.getUser());
		patientDAO.addPatient(patient);
		
		return "success";
	}

//	public String listPatients() {
//		patients = patientDAO.getPatients();
//		return "success";
//	}

	
}
