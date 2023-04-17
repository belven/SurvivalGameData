package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.mission.MissionType;

public class ContainerData extends RowData {
	public static String ContainerDataTable = "\\ContainerData.csv";
	public static ArrayList<ContainerData> ContainerData = new ArrayList<>();

	int slots;
	String name;
	String mesh;
	MissionType type;

	public ContainerData() {
		super(ContainerDataTable);
		if (ContainerData.size() > 0) {
			ID = GetLastID() + 1;
		}

		ContainerData.add(this);
	}

	public static ContainerData CreateContainerData(int slots, String name, String mesh, MissionType type) {
		ContainerData a = new ContainerData();
		a.slots = slots;
		a.name = name;
		a.mesh = mesh;
		a.type = type;
		return a;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(slots));
		rowData.add(name);
		rowData.add(mesh);
		rowData.add(type.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return ContainerData.get(ContainerData.size() - 1).ID;
	}

}
