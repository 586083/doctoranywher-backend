package com.doctoranywhere.doctoranywhere.dto;

import java.util.List;

public class Patient {
	
	private int patientId;
	private String patientFirstName;
	private String patientLastName;
	private int patientAge;
	private String patientSex;
	private String patientContactNumber;
	List<PatientAddress> patientAddress;
	private String patientAddressString;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public String getPatientContactNumber() {
		return patientContactNumber;
	}
	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}
	public List<PatientAddress> getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(List<PatientAddress> patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientAddressString() {
		return patientAddressString;
	}
	public void setPatientAddressString(String patientAddressString) {
		this.patientAddressString = patientAddressString;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", patientAge=" + patientAge + ", patientSex=" + patientSex
				+ ", patientContactNumber=" + patientContactNumber + ", patientAddress=" + patientAddress
				+ ", patientAddressString=" + patientAddressString + "]";
	}
	
	
}
