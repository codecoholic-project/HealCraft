package com.web.HealCraft.common.dto;

public enum RoomType {
	AC_GENERAL_ROOM("AC GENERAL ROOM"),
	NON_AC_GENERAL_ROOM("NON AC GENERAL ROOM"),
	
	AC_SINGLE_ROOM("AC SINGLE ROOM"),
	NON_AC_SINGLE_ROOM("NON AC SINGLE ROOM"),
	
	AC_DOUBLE_BED_ROOM("AC DOUBLE BED ROOM"),
	
	AC_SUITE_PREMIUM("AC SUITE PREMIUM"),
	AC_SUITE_LUXURY("AC SUITE LUXURY");
	
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
			default:
				return RoomType.NON_AC_SINGLE_ROOM;
		}
	}

}
