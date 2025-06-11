package com.web.HealCraft.common.dto;

public class PackageDisplay {
	
	private Long id;
	
	private String name;
	
	private Double price;
	
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PackageDisplay [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
