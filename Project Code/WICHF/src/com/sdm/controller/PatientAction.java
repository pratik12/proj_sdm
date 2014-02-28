package com.sdm.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdm.DAO.PatientDAO;
import com.sdm.DAO.UserDAO;
import com.sdm.model.User;
import com.sdm.model.Patient;

public class PatientAction extends ActionSupport implements ModelDriven<Patient> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	Patient patient = new Patient();
	User user = new User();
	UserDAO userDAO = new UserDAO();
	List<Patient> patients = new ArrayList<Patient>();
	PatientDAO patientDAO = new PatientDAO();

	@Override
	public Patient getModel() {
		return patient;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String addPatient() {
		System.out.println("*********");
		System.out.println(patient.getUserId());
		System.out.println(patient.getPassword());
		user.setUserId(patient.getUserId());
		user.setPassword(patient.getPassword());
		user.setAccessLevel("user");
		userDAO.addUser(user);
		patientDAO.addPatient(patient);
		
		return "success";
	}

	public String listPatients() {
		patients = patientDAO.getPatients();
		return "success";
	}

	
}
