package com.web.HealCraft.common.dto;

public enum FoodType {
	CONTINENTAL_VEG("CONTINENTAL VEG"),
	CONTINENTAL_NONVEG("CONTINENTAL NONVEG"),
	
	INDIAN_VEG("INDIAN VEG"),
	INDIAN_NONVEG("INDIAN NONVEG");
	
	public String name;

	FoodType(String name) {
		
	}
	
	
	public static String nameFromId(FoodType id)
	{
		switch(id)
		{
		
			case CONTINENTAL_VEG:
				return "CONTINENTAL VEG";
			case CONTINENTAL_NONVEG:
				return "CONTINENTAL NONVEG";
			case INDIAN_VEG:
				return "INDIAN VEG";
			case INDIAN_NONVEG:
				return "INDIAN NONVEG";
		
			default:
				return "";
		
		}
	
	}
	public static FoodType idFromName(String name)
	{
		switch(name)
		{
			case "CONTINENTAL VEG":
				return FoodType.CONTINENTAL_VEG;
			case "CONTINENTAL NONVEG":
				return FoodType.CONTINENTAL_NONVEG;
			case "INDIAN VEG":
				return FoodType.INDIAN_VEG;
			case "INDIAN NONVEG":
				return FoodType.INDIAN_NONVEG;
			
			default:
				return FoodType.INDIAN_VEG;
		}
	}
	
}
