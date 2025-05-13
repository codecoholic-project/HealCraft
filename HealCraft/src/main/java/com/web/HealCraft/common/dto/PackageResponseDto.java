package com.web.HealCraft.common.dto;

public class PackageResponseDto {

private Long id;
	
	private String name;
	
	private String price;
	
	private RoomType roomtype;
	
	private FoodType foodtype;
	
	private boolean nursefacility;
	
	private boolean pickdrop;
	
	private boolean postcare;
	
	private boolean physiotherapy;
	
	private DepartmentDisplay department;
	
	private HospitalDisplay  hospital;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public RoomType getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

	public FoodType getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(FoodType foodtype) {
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

	@Override
	public String toString() {
		return "PackageResponseDto [id=" + id + ", name=" + name + ", price=" + price + ", roomtype=" + roomtype
				+ ", foodtype=" + foodtype + ", nursefacility=" + nursefacility + ", pickdrop=" + pickdrop
				+ ", postcare=" + postcare + ", physiotherapy=" + physiotherapy + ", department=" + department
				+ ", hospital=" + hospital + "]";
	}
	
}
