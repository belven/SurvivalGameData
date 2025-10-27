package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.items.ContainerData;
import com.belven.rpg.items.RowData;

public class MissionContainer extends RowData {

	public MissionType type;
	public String containerName;
	public static String MissionContainerTable = "\\MissionContainerData.csv";
	public static ArrayList<MissionContainer> MissionContainers = new ArrayList<>();

	public MissionContainer(MissionType type, String containerName) {
		super(MissionContainerTable);

		this.type = type;
		this.containerName = containerName;

		if (MissionContainers.size() > 0) {
			ID = GetLastID() + 1;
		}
		MissionContainers.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(type.toString());
		rowData.add(GetString(ContainerData.GetContainerByName(containerName)));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return MissionContainers.get(MissionContainers.size() - 1).ID;
	}

}
