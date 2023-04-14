package com.belven.rpg.mission;

public class MissionLoadoutData {
	public MissionLoadoutData(MissionType type, String loadoutName) {
		super();
		this.type = type;
		this.loadoutName = loadoutName;
	}

	public MissionType type;
	public String loadoutName;

}