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
	@Table(name = "otpackage")
	public class PackageEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String name;
		
		private Double price;
		
		@Enumerated(EnumType.STRING)
		private RoomType roomtype;
		
		@Enumerated(EnumType.STRING)
		private FoodType foodtype;
		
		private boolean nursefacility;
		
		private boolean pickdrop;
		
		private boolean postcare;
		
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
			return "PackageEntity [id=" + id + ", name=" + name + ", price=" + price + ", roomtype=" + roomtype
					+ ", foodtype=" + foodtype + ", nursefacility=" + nursefacility + ", pickdrop=" + pickdrop
					+ ", postcare=" + postcare + ", physiotherapy=" + physiotherapy + ", departmentId=" + departmentId
					+ ", hospitalId=" + hospitalId + "]";
		}
		
}
