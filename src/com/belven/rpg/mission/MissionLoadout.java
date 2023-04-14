package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.items.RowData;

public class MissionLoadout extends RowData {
	public MissionLoadoutData data;

	public static String MissonTable = "\\MissionLoadoutData.csv";
	public static ArrayList<MissionLoadout> MissionLoadouts = new ArrayList<>();

	public MissionLoadout(MissionLoadoutData data) {
		super(MissonTable);

		this.data = data;

		if (MissionLoadouts.size() > 0) {
			ID = GetLastID() + 1;
		}

		MissionLoadouts.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(GetLoadoutByName(data.loadoutName)));
		rowData.add(data.type.toString());
		return rowData.toArray(new String[0]);
	}

	public int GetLoadoutByName(String name) {
		for (Loadout i : Loadout.loadouts) {
			if (i.getData().name.equals(name))
				return i.ID;
		}

		return -1;
	}

	@Override
	public int GetLastID() {
		return MissionLoadouts.get(MissionLoadouts.size() - 1).ID;
	}

	public MissionLoadoutData getData() {
		return data;
	}

	public static MissionLoadout CreateMissonLoadout(MissionLoadoutData md) {
		return new MissionLoadout(md);
	}

}
