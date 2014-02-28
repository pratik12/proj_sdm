package com.sdm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="h_card_no")
	private String healthCardNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	//private String formDate;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phone_no")
	private int phoneNumber;
	
	@Column(name="patient_name")
	private String name;
	
	@Column(name="annual_checkup")
	private boolean isAnnualCheckUpDone;
	
	
	@OneToOne
    @JoinColumn(name="user_id")
	private User user;


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

	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = Date.valueOf(birthDate);;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//	public String getFormDate() {
//		return formDate;
//	}
//	public void setFormDate(String formDate) {
//		this.formDate = formDate;
//		this.birthDate = Date.valueOf(formDate); //Format should be yyyy-MM-dd
//	}
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
