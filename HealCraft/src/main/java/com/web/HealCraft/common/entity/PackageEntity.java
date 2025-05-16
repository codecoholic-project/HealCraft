package com.web.HealCraft.common.entity;

import com.web.HealCraft.common.dto.FoodType;
import com.web.HealCraft.common.dto.RoomType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "ot_package")
	public class PackageEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String name;
		
		private Double price;
		
		@Enumerated(EnumType.STRING)
		private RoomType roomType;
		
		@Enumerated(EnumType.STRING)
		private FoodType foodType;
		
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

		public RoomType getRoomType() {
			return roomType;
		}

		public void setRoomType(RoomType roomType) {
			this.roomType = roomType;
		}

		public FoodType getFoodType() {
			return foodType;
		}

		public void setFoodType(FoodType foodType) {
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
			return "PackageEntity [id=" + id + ", name=" + name + ", price=" + price + ", roomType=" + roomType
					+ ", foodType=" + foodType + ", nurseFacility=" + nurseFacility + ", pickDrop=" + pickDrop
					+ ", postCare=" + postCare + ", physiotherapy=" + physiotherapy + ", departmentId=" + departmentId
					+ ", hospitalId=" + hospitalId + "]";
		}

}
