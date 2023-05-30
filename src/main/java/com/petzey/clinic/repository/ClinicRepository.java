package com.petzey.clinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petzey.clinic.entities.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long>{
	
	@Query(value = "select clinic from Clinic clinic where lower(clinic.clinicName) = :name")
	public List<Clinic> getByName(@Param(value = "name") String name);
}
