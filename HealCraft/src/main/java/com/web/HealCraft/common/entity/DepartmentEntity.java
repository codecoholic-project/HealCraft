package com.web.HealCraft.common.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private boolean active;
	
	@ManyToMany(mappedBy = "departments")
    private List<HospitalEntity> hospitals;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public List<HospitalEntity> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<HospitalEntity> hospitals) {
		this.hospitals = hospitals;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", name=" + name + ", description=" + description + ", active=" + active
				+ ", hospitals=" + hospitals + "]";
	}

}








