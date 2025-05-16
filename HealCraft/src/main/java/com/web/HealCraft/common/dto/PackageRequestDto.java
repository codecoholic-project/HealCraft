package com.web.HealCraft.common.dto;

public class PackageRequestDto {

	private Long id;
	
	private String name;
	
	private Double price;
	
	private String roomType;
	
	private String foodType;
	
	private boolean nurseFacility;
	
	private boolean pickDrop;
	
	private boolean postCare;
	
	private boolean physiotherapy;
	
	private Long departmentId;
	
	private Long hospitalId;

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

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public boolean isNurseFacility() {
		return nurseFacility;
	}

	public void setNurseFacility(boolean nurseFacility) {
		this.nurseFacility = nurseFacility;
	}

	public boolean isPickDrop() {
		return pickDrop;
	}

	public void setPickDrop(boolean pickDrop) {
		this.pickDrop = pickDrop;
	}

	public boolean isPostCare() {
		return postCare;
	}

	public void setPostCare(boolean postCare) {
		this.postCare = postCare;
	}

	public boolean isPhysiotherapy() {
		return physiotherapy;
	}

	public void setPhysiotherapy(boolean physiotherapy) {
		this.physiotherapy = physiotherapy;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "PackageRequestDto [id=" + id + ", name=" + name + ", price=" + price + ", roomType=" + roomType
				+ ", foodType=" + foodType + ", nurseFacility=" + nurseFacility + ", pickDrop=" + pickDrop
				+ ", postCare=" + postCare + ", physiotherapy=" + physiotherapy + ", departmentId=" + departmentId
				+ ", hospitalId=" + hospitalId + "]";
	}

}
