package com.doctoranywhere.doctoranywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctoranywhere.doctoranywhere.constant.RequestMappingConstant;
import com.doctoranywhere.doctoranywhere.dto.Patient;
import com.doctoranywhere.doctoranywhere.dto.PatientAddress;
import com.doctoranywhere.doctoranywhere.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientServiceImpl;
	
	@GetMapping(value = RequestMappingConstant.FETCH_ALL_PATIENT)
	public List<Patient> fetchAllPatient(){
		return patientServiceImpl.fetchAllPatient();
	}
	
	@PostMapping(value = RequestMappingConstant.DELETE_PATIENT)
	public boolean deletePatient(@RequestBody Patient patient){
		return patientServiceImpl.deletePatient(patient);
	}
	
	@PostMapping(value = RequestMappingConstant.CREATE_PATIENT)
	public boolean createPatient(@RequestBody Patient patient){
		return patientServiceImpl.createPatient(patient);
	}
	
	@PostMapping(value = RequestMappingConstant.CREATE_PATIENT_ADDRESS)
	public boolean createPatientAddress(@RequestBody PatientAddress patientAddress){
		return patientServiceImpl.createPatientAddress(patientAddress);
	}
	
	@PostMapping(value = RequestMappingConstant.FETCH_MULTIPLE_PATIENT_ADDRESS)
	public List<PatientAddress> fetchMultiplePatientAddress(@RequestBody Patient patient){
		return patientServiceImpl.fetchMultiplePatientAddress(patient);
	}
	
	@PostMapping(value = RequestMappingConstant.EDIT_PATIENT)
	public boolean editPatient(@RequestBody Patient patient){
		return patientServiceImpl.editPatient(patient);
	}
	
	@PostMapping(value = RequestMappingConstant.EDIT_PATIENT_ADDRESS)
	public boolean editPatientAddress(@RequestBody PatientAddress patientAddress){
		return patientServiceImpl.editPatientAddress(patientAddress);
	}
	
	@PostMapping(value = RequestMappingConstant.DELETE_PATIENT_ADDRESS)
	public boolean deletePatientAddress(@RequestBody PatientAddress patientAddress){
		return patientServiceImpl.deletePatientAddress(patientAddress);
	}
}
