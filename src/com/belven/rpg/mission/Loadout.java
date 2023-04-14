package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.items.Item;
import com.belven.rpg.items.RowData;

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
		rowData.add(data.name);
		rowData.add(GetString(GetItemByName(data.weapon)));
		rowData.add(GetString(GetItemByName(data.headArmour)));
		rowData.add(GetString(GetItemByName(data.chestArmour)));
		rowData.add(GetString(GetItemByName(data.vestArmour)));
		rowData.add(GetString(GetItemByName(data.legsArmour)));
		rowData.add(GetString(data.health));
		rowData.add(GetString(data.moveSpeed));
		return rowData.toArray(new String[0]);
	}
	
	public int GetItemByName(String name) {
		for(Item i : Item.items) {		
			if(i.GetData().name.equals(name))
				return i.ID;
		}
		
		return -1;
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
