package com.web.HealCraft.common.dto;

public class DoctorRequestDto {
	
	private Long id;
	
	private String name;
	
	private String degree;
	
	private String experience;
	
	private boolean consultant;
	
	private String  about;
	
	private Long deptId;
	
	private Long hospiId;

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
	
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	

	public Long getHospiId() {
		return hospiId;
	}

	public void setHospiId(Long hospiId) {
		this.hospiId = hospiId;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", degree=" + degree + ", experience=" + experience
				+ ", consultant=" + consultant + ", about=" + about + ", deptId=" + deptId + ", hospiId=" + hospiId
				+ "]";
	}

	

	

}
