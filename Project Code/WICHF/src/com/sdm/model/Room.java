package com.sdm.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Room {

	@Id
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="room_no")
	private int roomNumber;
	
	@Column(name="room_status")
	private String room_status;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = 65;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
		
}
