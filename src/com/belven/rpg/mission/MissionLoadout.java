package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.RowData;

public class MissionLoadout extends RowData {
	public MissionLoadoutData data;

	public static String TableName = "\\MissionLoadoutData.csv";
	public static ArrayList<MissionLoadout> Data = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("MissionLoadout", "MissionLoadout", new TableColumn("ID", ValueType.Integer), new TableColumn("LoadoutID", ValueType.Integer),
			new TableColumn("Type", ValueType.Enumeration, MissionType.class.getSimpleName()));

	public MissionLoadout(MissionLoadoutData data) {
		super(TableName);
		this.data = data;
		IncrementID(Data);
		Data.add(this);
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
		for (Loadout i : Loadout.Data) {
			if (i.getData().name.equals(name))
				return i.ID;
		}

		return -1;
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

	public MissionLoadoutData getData() {
		return data;
	}

	public static MissionLoadout CreateMissonLoadout(MissionLoadoutData md) {
		return new MissionLoadout(md);
	}

}
