package com.company.varnaa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.varnaa.model.Prescription;
import com.company.varnaa.repository.PrescriptionRepository;

@Service
@Transactional
public class PrescriptionService {
	
	@Autowired
	private PrescriptionRepository repository;
	
	public void save(Prescription Prescription) {
		repository.save(Prescription);
	}
	
	public List<Prescription> findByPatientName(String patientName){
		
			return repository.findByPatientName(patientName);
	}
}
