package com.doctoranywhere.doctoranywhere.dto;

public class PatientAddress {
	
	private int patientId;
	private int patientAddressId;
	private String patientAddress1;
	private String patientAddress2;
	private String patientCity;
	private String patientCountry;
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientAddress1() {
		return patientAddress1;
	}
	public void setPatientAddress1(String patientAddress1) {
		this.patientAddress1 = patientAddress1;
	}
	public String getPatientAddress2() {
		return patientAddress2;
	}
	public void setPatientAddress2(String patientAddress2) {
		this.patientAddress2 = patientAddress2;
	}
	public String getPatientCity() {
		return patientCity;
	}
	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}
	public String getPatientCountry() {
		return patientCountry;
	}
	public void setPatientCountry(String patientCountry) {
		this.patientCountry = patientCountry;
	}
	public int getPatientAddressId() {
		return patientAddressId;
	}
	public void setPatientAddressId(int patientAddressId) {
		this.patientAddressId = patientAddressId;
	}
	@Override
	public String toString() {
		return "PatientAddress [patientId=" + patientId + ", patientAddress1=" + patientAddress1 + ", patientAddress2="
				+ patientAddress2 + ", patientCity=" + patientCity + ", patientCountry=" + patientCountry + "]";
	}
	
	
}
