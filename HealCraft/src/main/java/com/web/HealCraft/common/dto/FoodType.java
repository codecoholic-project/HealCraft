package com.web.HealCraft.common.dto;

public enum FoodType {
	CONTINENTAL_VEG("CONTINENTAL VEG"),
	CONTINENTAL_NONVEG("CONTINENTAL NONVEG"),
	
	INDIAN_VEG("INDIAN VEG"),
	INDIAN_NONVEG("INDIAN NONVEG");
	
	public String name;

	private FoodType(String name) {
		this.name = name;
	}
	
	

}
