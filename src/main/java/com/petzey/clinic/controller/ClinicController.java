package com.petzey.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petzey.clinic.entities.Clinic;
import com.petzey.clinic.service.ClinicService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/clinics")
public class ClinicController {

	@Autowired(required = true)
	private ClinicService clinicService;

	@PostMapping("/create/clinic")
	public ResponseEntity<?> addClinic(@RequestBody Clinic clinic) {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(clinicService.addClinic(clinic), HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/clinic/get/all")
	public ResponseEntity<?> getClinics() {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(clinicService.getAllClinic(), HttpStatus.OK);
		return response;
	}

	@PutMapping("/clinic/update")
	public ResponseEntity<?> editClinic(@RequestBody Clinic clinic) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(clinicService.editClinic(clinic), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@DeleteMapping("/clinic/{clinicID}/remove")
	public void deleteClinic(@PathVariable(value = "clinicID") long clinicId) {
		try {
			clinicService.deleteClinic(clinicId);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@PutMapping("/clinic/{clinicID}/status/{clinicStatus}")
	public ResponseEntity<?> updateClinicStatus(@PathVariable(value = "clinicID") long clinicId,
			@PathVariable(value = "clinicStatus") String status) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(clinicService.updateStatus(clinicId, status), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@GetMapping("/clinic/get/name/{clinicname}")
	public ResponseEntity<?> getClinicByName(@PathVariable(value = "clinicname") String clinicName) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(clinicService.getClinicByName(clinicName), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
