package com.sdm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@Column(name="appointment_id")
	private int appointmentId;
	
	@Column(name="time_slot")
	private int timeSlot;
	
	@Column(name="booked_through")
	private String bookedThrough;
	
	@Column(name="visit_type_id")
	private int visitTypeId;
	
	@Column(name="active")
	private Boolean active;
	
	@Column(name="booked_date")
	private Date bookedDate;
	
	@Column(name="appointment_date")
	private Date appointmentDate;
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@ManyToOne(targetEntity = Doctor.class)
	@JoinColumn(name="doctor_id", referencedColumnName="doctor_id")
	
	private Doctor doctor;
	
//	@ManyToOne(targetEntity = Room.class)
//	@JoinColumn(name="room_id")
	private int roomId;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getBookedThrough() {
		return bookedThrough;
	}

	public void setBookedThrough(String bookedThrough) {
		this.bookedThrough = bookedThrough;
	}

	public int getVisitTypeId() {
		return visitTypeId;
	}

	public void setVisitTypeId(int visitTypeId) {
		this.visitTypeId = visitTypeId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
	


}
