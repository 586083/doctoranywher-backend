package com.doctoranywhere.doctoranywhere.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.doctoranywhere.doctoranywhere.dto.Patient;
import com.doctoranywhere.doctoranywhere.dto.PatientAddress;

@Mapper
public interface PatientMapper {
	public List<Patient> fetchAllPatient();
	public boolean deletePatient(Patient patient);
	public boolean createPatient(Patient patient);
	public boolean createPatientAddress(PatientAddress patientAddress);
	public List<PatientAddress> fetchMultiplePatientAddress(Patient patient);
	public boolean editPatient(Patient patient);
	public boolean editPatientAddress(PatientAddress patientAddress);
	public boolean deletePatientAddress(PatientAddress patientAddress);
}
