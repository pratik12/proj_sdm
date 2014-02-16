package com.wichf;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT")
public class Patient {

	private long id;

	private String name;

	public Patient(String name) {
		super();
		this.name = name;
	}

	public Patient() {}

	@Id
	@GeneratedValue
	@Column(name="patient_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="pname", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
