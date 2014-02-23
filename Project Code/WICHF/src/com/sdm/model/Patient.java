package com.sdm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="h_Card_no")
	private String healthCardNumber;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phone_no")
	private int phoneNumber;
	
	@Column(name="patient_name")
	private String name;
	
	@Column(name="annual_checkup")
	private boolean isAnnualCheckUpDone;
	
	@Column(name="Patientcol")
	private String patientCol;
	
	@Column(name="user_id")
	private String userId;

	private String password;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getHealthCardNumber() {
		return healthCardNumber;
	}
	public void setHealthCardNumber(String healthCardNumber) {
		this.healthCardNumber = healthCardNumber;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAnnualCheckUpDone() {
		return isAnnualCheckUpDone;
	}
	public void setAnnualCheckUpDone(boolean isAnnualCheckUpDone) {
		this.isAnnualCheckUpDone = isAnnualCheckUpDone;
	}
	public String getPatientCol() {
		return patientCol;
	}
	public void setPatientCol(String patientCol) {
		this.patientCol = patientCol;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
