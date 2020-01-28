package com.doctoranywhere.doctoranywhere.service.Impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.doctoranywhere.doctoranywhere.constant.DoctoranywhereConstant;
import com.doctoranywhere.doctoranywhere.dao.PatientMapper;
import com.doctoranywhere.doctoranywhere.dto.Patient;
import com.doctoranywhere.doctoranywhere.dto.PatientAddress;
import com.doctoranywhere.doctoranywhere.service.PatientService;
import com.doctoranywhere.doctoranywhere.service.SequenceService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PatientServiceImpl implements PatientService{
	
	private static final Logger log=LogManager.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private PatientMapper patientMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Override
	public List<Patient> fetchAllPatient() {
		return fillAddress(patientMapper.fetchAllPatient());
	}
	
	public List<Patient> fillAddress(List<Patient> obj) {
		obj.stream().forEach(inst -> {
			fillAddress(inst);
		});
		log.debug("Patient Details"+obj.toString());
		return obj;
	}
	
	public Patient fillAddress(Patient obj) {
		StringBuilder address=new StringBuilder();
		obj.getPatientAddress().stream().forEach(inst -> {
			address.append(
			(inst.getPatientAddress1() == null ? DoctoranywhereConstant.EMPTY_STRING : inst.getPatientAddress1() )+DoctoranywhereConstant.SYMBOL_COMMA+
			(inst.getPatientAddress2() == null ? DoctoranywhereConstant.EMPTY_STRING : inst.getPatientAddress2())+DoctoranywhereConstant.SYMBOL_COMMA+
			(inst.getPatientCity() == null ? DoctoranywhereConstant.EMPTY_STRING : inst.getPatientCity())+DoctoranywhereConstant.SYMBOL_COMMA+
			(inst.getPatientCountry() == null ? DoctoranywhereConstant.EMPTY_STRING : inst.getPatientCountry())+DoctoranywhereConstant.SYMBOL_PIPE
			);
		});
		if(address.length() > 1 ) {
			obj.setPatientAddressString(address.substring(0, address.length()-1));
		}else {
			obj.setPatientAddressString(DoctoranywhereConstant.EMPTY_STRING);
		}
		return obj;
	}

	@Override
	public boolean deletePatient(Patient patient) {
		return patientMapper.deletePatient(patient);
	}

	@Override
	public boolean createPatient(Patient patient) {
		patient.setPatientId(sequenceService.getPatientSeq());
		return patientMapper.createPatient(patient);
	}

	@Override
	public boolean createPatientAddress(PatientAddress patientAddress) {
		patientAddress.setPatientAddressId(sequenceService.getPatientAddressSeq());
		return patientMapper.createPatientAddress(patientAddress);
	}

	@Override
	public List<PatientAddress> fetchMultiplePatientAddress(Patient patient) {
		return patientMapper.fetchMultiplePatientAddress(patient);
	}

	@Override
	public boolean editPatient(Patient patient) {
		return patientMapper.editPatient(patient);
	}

	@Override
	public boolean editPatientAddress(PatientAddress patientAddress) {
		return patientMapper.editPatientAddress(patientAddress);
	}

	@Override
	public boolean deletePatientAddress(PatientAddress patientAddress) {
		return patientMapper.deletePatientAddress(patientAddress);
	}
}
