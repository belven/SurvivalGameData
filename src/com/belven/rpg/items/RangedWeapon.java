package com.belven.rpg.items;

import java.util.ArrayList;

public class RangedWeapon extends RowData {
	public static ArrayList<RangedWeapon> rangedWeapons = new ArrayList<>();
	public static String RangedWeaponTable = "\\RangedWeaponData.csv";

	int weaponID;
	float accuracy;

	public RangedWeapon() {
		super(RangedWeaponTable);
		if (rangedWeapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		rangedWeapons.add(this);

	}
	
	public static RangedWeapon CreateRangedWeapon(int weaponID, float accuracy) {
		RangedWeapon rw = new RangedWeapon();
		rw.weaponID = weaponID;
		rw.accuracy = accuracy;
		return rw;
	}


	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(weaponID));
		rowData.add(String.valueOf(accuracy));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return rangedWeapons.get(rangedWeapons.size() - 1).ID;
	}
}