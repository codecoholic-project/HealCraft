package com.web.HealCraft.common.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "hospital")
public class HospitalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
		
	private String description;
	  
	private String address;
	   
	private Long contact;
	  
	private String email;
	  
	private String url;
	
	@ManyToMany
    @JoinTable(
        name = "hospital_department",
        joinColumns = @JoinColumn(name = "hospital_id"),
        inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<DepartmentEntity> departments = new ArrayList<>();

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
	
	public List<DepartmentEntity> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentEntity> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "HospitalEntity [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + ", url=" + url + ", departments=" + departments + "]";
	}

}

