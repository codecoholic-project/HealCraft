package com.web.HealCraft.common.dto;

import java.util.List;

public class HospitalResponseDto {
	
private Long id;
	
	private String name;
		
	private String description;
	  
	private String address;
	   
	private Long contact;
	  
	private String email;
	  
	private String url;
	
	private List<Department> departments;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "HospitalResponseDto [id=" + id + ", name=" + name + ", description=" + description + ", address="
				+ address + ", contact=" + contact + ", email=" + email + ", url=" + url + ", departments="
				+ departments + "]";
	}
	
	

}
