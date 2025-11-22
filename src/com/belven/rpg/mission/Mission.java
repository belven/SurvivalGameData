package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.RowData;

// TODO this class is unused
public class Mission extends RowData {
	public MissionData data;

	public static String MissionTable = "\\MissionData.csv";
	public static ArrayList<Mission> Missions = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("Mission", "Mission", new TableColumn("ID", ValueType.Integer),
			new TableColumn("Type", ValueType.Enumeration, MissionType.class.getSimpleName()));

	public Mission(MissionData data) {
		super(MissionTable);
		this.data = data;
		IncrementID(Missions);
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
		return GetLastID(Missions);
	}

	public MissionData getData() {
		return data;
	}

	public static Mission CreateMission(MissionData md) {
		return new Mission(md);
	}
}