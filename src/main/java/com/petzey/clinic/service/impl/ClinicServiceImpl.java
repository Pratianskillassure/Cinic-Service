package com.petzey.clinic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzey.clinic.entities.Clinic;
import com.petzey.clinic.enums.Status;
import com.petzey.clinic.exception.ResourceNotFoundException;
import com.petzey.clinic.repository.ClinicRepository;
import com.petzey.clinic.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService{
	
	@Autowired
	ClinicRepository clinicRepository;
	
	private static final Logger log = LoggerFactory.getLogger(Clinic.class);
	
	@Override
	public List<Clinic> getAllClinic() {
		log.info("fetching all clinic details");
		return clinicRepository.findAll();
	}

	@Override
	public Clinic addClinic(Clinic clinic) {
		log.info("Saving new clinic");
		return clinicRepository.save(clinic);
	}

	@Override
	public Clinic editClinic(Clinic clinic) throws ResourceNotFoundException {
		if(!clinicRepository.existsById(clinic.getClinicId())) {
			log.error("clinic id doesn't exist");
			throw new ResourceNotFoundException("Clinic Not Found with ID: " + clinic.getClinicId());
		}else {
			log.info("getting clinic of id " + clinic.getClinicId());
			Clinic existingClinic = clinicRepository.findById(clinic.getClinicId()).get();
			log.info("updating clinic");
			existingClinic.setClinicInfo(clinic.getClinicInfo());
			existingClinic.setClinicName(clinic.getClinicName());
			existingClinic.setDescription(clinic.getDescription());
			existingClinic.setLocation(clinic.getLocation());
			existingClinic.setPhoneNumber(clinic.getPhoneNumber());
			existingClinic.setStatus(clinic.getStatus());
			existingClinic.setTimings(clinic.getTimings());
			
			log.info("saving edited clinic");
			clinicRepository.save(existingClinic);
			return existingClinic;
		}
	}

	@Override
	public void deleteClinic(long clinicId) throws ResourceNotFoundException {
		if(!clinicRepository.existsById(clinicId) ) {
			log.error("clinic id doesn't exist to delete");
			throw new ResourceNotFoundException("Clinic Not Found with ID: " + clinicId);
		}else {
			log.info("deleted clinic with id " + clinicId);
			clinicRepository.deleteById(clinicId);
		}
		
	}

	@Override
	public Clinic updateStatus(long clinicId, String status) throws ResourceNotFoundException, IllegalArgumentException {
		Clinic existingClinic = null;
		if(!clinicRepository.existsById(clinicId) ) {
			log.error("clinic id doesn't exist to updatestatus");
			throw new ResourceNotFoundException("Clinic Not Found with ID: " + clinicId);
		}else {
			existingClinic = clinicRepository.findById(clinicId).get();
			if(status.equalsIgnoreCase(Status.APPROVED.toString())) {
				log.info("updating clinic status has APPROVED");
				existingClinic.setStatus(Status.APPROVED);
				clinicRepository.save(existingClinic);
			}else if (status.equalsIgnoreCase(Status.PENDING.toString())) {
				log.info("updating clinic status has PENDING");
				existingClinic.setStatus(Status.PENDING);
				clinicRepository.save(existingClinic);
			}else {
				log.error("The entred status is invalid");
				throw new IllegalArgumentException("The given status is invalid");
			}
		}
		return existingClinic ;
	}

	@Override
	public List<Clinic> getClinicByName(String name) throws ResourceNotFoundException {
		List<Clinic> clinics = clinicRepository.getByName(name);
		if(clinics.isEmpty()) {
			log.error("no clinic exist in records");
			throw new ResourceNotFoundException("no clinic exist in records");
		}
		return clinics;
	}

	
}
