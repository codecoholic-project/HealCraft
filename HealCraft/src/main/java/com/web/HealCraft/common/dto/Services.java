package com.web.HealCraft.common.dto;

public class Services {
	
	private String name;
	
	private String description;
	
	private boolean active;
	
	private boolean prime;

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
		return "Service [name=" + name + ", description=" + description + ", active=" + active + ", prime=" + prime
				+ "]";
	}
	
}
