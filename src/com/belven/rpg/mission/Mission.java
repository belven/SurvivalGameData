package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.items.RowData;

public class Mission extends RowData {
	public MissionData data;

	public static String MissionTable = "\\MissionData.csv";
	public static ArrayList<Mission> Missions = new ArrayList<>();

	public Mission(MissionData data) {
		super(MissionTable);

		this.data = data;

		if (Missions.size() > 0) {
			ID = GetLastID() + 1;
		}

		Missions.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(data.type.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return Missions.get(Missions.size() - 1).ID;
	}

	public MissionData getData() {
		return data;
	}

	public static Mission CreateMission(MissionData md) {
		return new Mission(md);
	}
}