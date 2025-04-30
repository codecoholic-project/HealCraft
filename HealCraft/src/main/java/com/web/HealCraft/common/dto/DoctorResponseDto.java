package com.web.HealCraft.common.dto;

public class DoctorResponseDto 
{
	private Long id;
	
	private String name;
	
	private String degree;
	
	private String experience;
	
	private boolean consultant;
	
	private String  about;
	
	private DepartmentDisplay department;
	
	private HospitalResponseDto hospital;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public boolean isConsultant() {
		return consultant;
	}

	public void setConsultant(boolean consultant) {
		this.consultant = consultant;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public DepartmentDisplay getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDisplay department) {
		this.department = department;
	}

	public HospitalResponseDto getHospital() {
		return hospital;
	}

	public void setHospital(HospitalResponseDto hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "DoctorResponseDto [id=" + id + ", name=" + name + ", degree=" + degree + ", experience=" + experience
				+ ", consultant=" + consultant + ", about=" + about + ", department=" + department + ", hospital="
				+ hospital + "]";
	}
	
}
