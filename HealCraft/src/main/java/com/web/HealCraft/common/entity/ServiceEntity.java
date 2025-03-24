package com.web.HealCraft.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class ServiceEntity {
	
	@Id
	private Long id;
	
	private String name;
	
	private String description;
	
	private boolean active;
	
	private boolean prime;

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

	public boolean isPrime() {
		return prime;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}

	@Override
	public String toString() {
		return "ServiceEntity [id=" + id + ", name=" + name + ", description=" + description + ", active=" + active
				+ ", prime=" + prime + "]";
	}
	

}
