package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.ContainerData;
import com.belven.rpg.items.RowData;

public class MissionContainer extends RowData {
	public static String MissionContainerTable = "\\MissionContainerData.csv";
	public static ArrayList<MissionContainer> MissionContainers = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("MissionContainer", "MissionContainer", new TableColumn("ID", ValueType.Integer),
			new TableColumn("Type", ValueType.Enumeration, MissionType.class.getSimpleName()), new TableColumn("ContainerID", ValueType.Integer));

	public MissionType type;
	public String containerName;

	public static MissionContainer CreateMissionContainer(MissionType type, String containerName) {
		MissionContainer mc = new MissionContainer();
		mc.type = type;
		mc.containerName = containerName;
		return mc;
	}

	public MissionContainer() {
		super(MissionContainerTable);
		IncrementID(MissionContainers);
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
		return GetLastID(MissionContainers);
	}

}
