package com.belven.rpg.items;

import java.util.ArrayList;

public class ContainerData extends RowData {
	public static String ContainerDataTable = "\\ContainerData.csv";
	public static ArrayList<ContainerData> ContainerData = new ArrayList<>();

	int slots;
	public String name;
	String mesh;

	public ContainerData() {
		super(ContainerDataTable);
		if (ContainerData.size() > 0) {
			ID = GetLastID() + 1;
		}

		ContainerData.add(this);
	}

	public static ContainerData CreateContainerData(int slots, String name, String mesh) {
		ContainerData a = new ContainerData();
		a.slots = slots;
		a.name = name;
		a.mesh = mesh;
		return a;
	}

	public static int GetContainerByName(String name) {
		for (ContainerData cd : ContainerData) {
			if (cd.name.equals(name)) {
				return cd.ID;
			}
		}
		return -1;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(slots));
		rowData.add(name);
		rowData.add(mesh);
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return ContainerData.get(ContainerData.size() - 1).ID;
	}

}
