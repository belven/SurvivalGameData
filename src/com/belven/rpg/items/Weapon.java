package com.belven.rpg.items;

import java.util.ArrayList;

public class Weapon extends RowData {
	public static ArrayList<Weapon> weapons = new ArrayList<>();
	public static String WeaponTable = "\\WeaponData.csv";

	private WeaponData data;

	public Weapon(WeaponData data) {
		super(WeaponTable);
		if (weapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		this.data = data;
		weapons.add(this);
	}

	public static Weapon CreateWeapon(WeaponData data) {
		 return new Weapon(data);
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(GetData().itemID));
		rowData.add(GetData().type.toString());
		rowData.add(GetString(GetData().range));
		rowData.add(GetString(GetData().healthChange));
		rowData.add(GetString(GetData().useRate));
		rowData.add(GetString(GetData().heals));		
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return weapons.get(weapons.size() - 1).ID;
	}

	public WeaponData GetData() {
		return data;
	}
}
