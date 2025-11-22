package com.belven.rpg.weapons;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.GearType;
import com.belven.rpg.items.RowData;

public class Weapon extends RowData {
	public static ArrayList<Weapon> weapons = new ArrayList<>();
	public static String WeaponTable = "\\WeaponData.csv";

	public static TableDefinition Table_Definition = new TableDefinition("WeaponData", "WeaponData", new TableColumn("ID", ValueType.Integer), new TableColumn("ItemID", ValueType.Integer),
			new TableColumn("Type", ValueType.Enumeration, WeaponType.class.getSimpleName()), new TableColumn("GearType", ValueType.Enumeration, GearType.class.getSimpleName()),
			new TableColumn("Range", ValueType.Float), new TableColumn("HealthChange", ValueType.Float), new TableColumn("UseRate", ValueType.Float), new TableColumn("Heals", ValueType.Boolean));

	private WeaponData data;

	public Weapon(WeaponData data) {
		super(WeaponTable);
		IncrementID(weapons);
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
		rowData.add(GetData().gearType.toString());
		rowData.add(GetString(GetData().range));
		rowData.add(GetString(GetData().healthChange));
		rowData.add(GetString(GetData().useRate));
		rowData.add(GetString(GetData().heals));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(weapons);
	}

	public WeaponData GetData() {
		return data;
	}
}
