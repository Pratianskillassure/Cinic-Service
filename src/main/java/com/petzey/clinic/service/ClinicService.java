package com.petzey.clinic.service;

import java.util.List;
import com.petzey.clinic.entities.Clinic;
import com.petzey.clinic.enums.Status;
import com.petzey.clinic.exception.ResourceNotFoundException;

public interface ClinicService {
	
	public List<Clinic> getAllClinic();
	
	public Clinic addClinic(Clinic clinic);
	
	public Clinic editClinic(Clinic clinic) throws ResourceNotFoundException;
	
	public void deleteClinic(long clinicId) throws ResourceNotFoundException;
	
	public Clinic updateStatus(long clinicId, String status) throws ResourceNotFoundException, IllegalArgumentException;
	
	public List<Clinic> getClinicByName(String name) throws ResourceNotFoundException;

}
