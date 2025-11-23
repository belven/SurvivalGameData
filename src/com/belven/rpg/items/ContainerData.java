package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class ContainerData extends RowData {
	public static String TableName = "\\ContainerData.csv";
	public static ArrayList<ContainerData> Data = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("ContainerData", "ContainerData", new TableColumn("ID", ValueType.Integer), new TableColumn("Slots", ValueType.Integer),
			new TableColumn("Name", ValueType.String), new TableColumn("Mesh", ValueType.String));

	int slots;
	String name;
	String mesh;

	public ContainerData() {
		super(TableName);
		IncrementID(Data);

		Data.add(this);
	}

	public static ContainerData CreateContainerData(int slots, String name, String mesh) {
		ContainerData a = new ContainerData();
		a.slots = slots;
		a.name = name;
		a.mesh = mesh;
		return a;
	}

	public static int GetContainerByName(String name) {
		for (ContainerData cd : Data) {
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
		return GetLastID(Data);
	}

}
