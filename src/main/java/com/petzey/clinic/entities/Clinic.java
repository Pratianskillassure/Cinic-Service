package com.petzey.clinic.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.petzey.clinic.enums.Status;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Clinic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clinicId;
	private String clinicName;
	private String clinicInfo;
	
	private String location;
	private String phoneNumber;
	private String timings;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Clinic(long clinicId, String clinicName, String clinicInfo, String location, String phoneNumber,
			String timings, String description, Status status) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.clinicInfo = clinicInfo;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.timings = timings;
		this.description = description;
		this.status = status;
	}

	public Clinic() {
		super();
	}

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicInfo() {
		return clinicInfo;
	}

	public void setClinicInfo(String clinicInfo) {
		this.clinicInfo = clinicInfo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
