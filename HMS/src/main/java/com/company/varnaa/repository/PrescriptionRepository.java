package com.company.varnaa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.varnaa.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,String> {

	List<Prescription> findByPatientName(String patientName);
}
