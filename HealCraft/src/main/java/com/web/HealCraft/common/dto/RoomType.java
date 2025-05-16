package com.web.HealCraft.common.dto;

public enum RoomType {
	AC_GENERAL_ROOM("AC GENERAL ROOM"),
	NON_AC_GENERAL_ROOM("NON AC GENERAL ROOM"),
	
	AC_SINGLE_ROOM("AC SINGLE ROOM"),
	NON_AC_SINGLE_ROOM("NON AC SINGLE ROOM"),
	
	AC_DOUBLE_BED_ROOM("AC DOUBLE BED ROOM"),
	
	AC_SUITE_PREMIUM_ROOM("AC SUITE PREMIUM ROOM"),
	AC_SUITE_LUXURY_ROOM("AC SUITE LUXURY ROOM");
	
	public String name;

	RoomType(String name) {
		
	}
	
	public static String nameFromId(RoomType id)
	{
		switch(id)
		{
			case AC_GENERAL_ROOM:
				return "AC GENERAL ROOM";
			case NON_AC_GENERAL_ROOM:
				return "NON AC GENERAL ROOM";
			case AC_SINGLE_ROOM:
				return "AC SINGLE ROOM";
			case NON_AC_SINGLE_ROOM:
				return "NON AC SINGLE ROOM";
			case AC_DOUBLE_BED_ROOM:
				return "AC DOUBLE BED ROOM";
			case AC_SUITE_PREMIUM_ROOM:
				return "AC SUITE PREMIUM ROOM";
			case AC_SUITE_LUXURY_ROOM:
				return "AC SUITE LUXURY ROOM";
				
			default:
				return "";
				
				
		}
	}
	
	public static RoomType idFromName(String name)
	{
		switch(name)
		{
			case "AC GENERAL ROOM":
				return RoomType.AC_GENERAL_ROOM;
			case "NON AC GENERAL ROOM":
				return RoomType.NON_AC_GENERAL_ROOM;
			case "AC SINGLE ROOM":
				return RoomType.AC_SINGLE_ROOM;
			case "NON AC SINGLE ROOM":
				return RoomType.NON_AC_SINGLE_ROOM;
			case "AC DOUBLE BED ROOM":
				return RoomType.AC_DOUBLE_BED_ROOM;
			case "AC SUITE PREMIUM ROOM":
				return RoomType.AC_SUITE_PREMIUM_ROOM;
			case "AC SUITE LUXURY ROOM":
				return RoomType.AC_SUITE_LUXURY_ROOM;
			default:
				return RoomType.NON_AC_GENERAL_ROOM;
		}
	}

}
