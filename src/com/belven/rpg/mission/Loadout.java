package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.CharacterType;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.RowData;

public class Loadout extends RowData {
	public LoadoutData data;

	public static String TableName = "\\LoadoutData.csv";
	public static ArrayList<Loadout> Data = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("Loadout", "Loadout", new TableColumn("ID", ValueType.Integer),
			new TableColumn("Type", ValueType.Enumeration, CharacterType.class.getSimpleName()), new TableColumn("Name", ValueType.String), new TableColumn("Weapon", ValueType.Integer),
			new TableColumn("HeadArmour", ValueType.Integer), new TableColumn("ChestArmour", ValueType.Integer), new TableColumn("VestArmour", ValueType.Integer),
			new TableColumn("LegsArmour", ValueType.Integer), new TableColumn("Health", ValueType.Integer), new TableColumn("MoveSpeed", ValueType.Integer));

	public Loadout(LoadoutData data) {
		super(TableName);
		this.data = data;
		IncrementID(Data);
		Data.add(this);
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
		for (Item i : Item.Data) {
			if (i.GetData().name.equals(name))
				return i.ID;
		}

		return -1;
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

	public LoadoutData getData() {
		return data;
	}

	public static Loadout CreateLoadout(LoadoutData ld) {
		return new Loadout(ld);
	}

}
