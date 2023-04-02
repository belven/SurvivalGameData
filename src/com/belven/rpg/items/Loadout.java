package com.belven.rpg.items;

import java.util.ArrayList;

public class Loadout extends RowData {
	public LoadoutData data;

	public static String LoadoutTable = "\\LoadoutData.csv";
	public static ArrayList<Loadout> loadouts = new ArrayList<>();
	

	public Loadout(LoadoutData data) {
		super(LoadoutTable);
		
		this.data = data;
		
		if (loadouts.size() > 0) {
			ID = GetLastID() + 1;
		}

		loadouts.add(this);
	}
	
	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(data.type.toString());
		rowData.add(GetString(data.entityID));
		rowData.add(GetString(data.weaponID));
		rowData.add(GetString(data.headArmourID));
		rowData.add(GetString(data.chestArmourID));
		rowData.add(GetString(data.legsArmourID));
		rowData.add(GetString(data.health));
		rowData.add(GetString(data.moveSpeed));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return loadouts.get(loadouts.size() - 1).ID;
	}

	public LoadoutData getData() {
		return data;
	}

	public static Loadout CreateLoadout(LoadoutData ld) {
		return new Loadout(ld);
	}

}
