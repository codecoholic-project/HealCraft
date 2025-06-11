package com.web.HealCraft.common.dto;

import java.util.List;

public class PackageResponseDto {

	private Long id;
	
	private String name;
	
	private Double price;
	
	private String roomtype;
	
	private String foodtype;
	
	private boolean nursefacility;
	
	private boolean pickdrop;
	
	private boolean postcare;
	
	private boolean physiotherapy;
	
	private DepartmentDisplay department;
	
	private HospitalDisplay  hospital;
	
	private List<String> foodTypeList;
	
	private List<String> roomTypeList;

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

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public boolean isNursefacility() {
		return nursefacility;
	}

	public void setNursefacility(boolean nursefacility) {
		this.nursefacility = nursefacility;
	}

	public boolean isPickdrop() {
		return pickdrop;
	}

	public void setPickdrop(boolean pickdrop) {
		this.pickdrop = pickdrop;
	}

	public boolean isPostcare() {
		return postcare;
	}

	public void setPostcare(boolean postcare) {
		this.postcare = postcare;
	}

	public boolean isPhysiotherapy() {
		return physiotherapy;
	}

	public void setPhysiotherapy(boolean physiotherapy) {
		this.physiotherapy = physiotherapy;
	}

	public DepartmentDisplay getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDisplay department) {
		this.department = department;
	}

	public HospitalDisplay getHospital() {
		return hospital;
	}

	public void setHospital(HospitalDisplay hospital) {
		this.hospital = hospital;
	}
	
	public List<String> getFoodTypeList() {
		return foodTypeList;
	}

	public void setFoodTypeList(List<String> foodTypeList) {
		this.foodTypeList = foodTypeList;
	}

	public List<String> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<String> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

	@Override
	public String toString() {
		return "PackageResponseDto [id=" + id + ", name=" + name + ", price=" + price + ", roomtype=" + roomtype
				+ ", foodtype=" + foodtype + ", nursefacility=" + nursefacility + ", pickdrop=" + pickdrop
				+ ", postcare=" + postcare + ", physiotherapy=" + physiotherapy + ", department=" + department
				+ ", hospital=" + hospital + ", foodTypeList=" + foodTypeList + ", roomTypeList=" + roomTypeList + "]";
	}
	
}
