package com.belven.rpg.weapons;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.RowData;

public class RangedWeapon extends RowData {
	public static ArrayList<RangedWeapon> Data = new ArrayList<>();
	public static String TableName = "\\RangedWeaponData.csv";

	public static TableDefinition Table_Definition = new TableDefinition("RangedWeapon", "RangedWeapon", new TableColumn("ID", ValueType.Integer), new TableColumn("WeaponID", ValueType.Integer),
			new TableColumn("Accuracy", ValueType.Float));

	int weaponID;
	float accuracy;

	public RangedWeapon() {
		super(TableName);
		IncrementID(Data);

		Data.add(this);

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
		return GetLastID(Data);
	}
}