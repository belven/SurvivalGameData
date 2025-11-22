package com.belven.rpg.crafting;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.RowData;

public class CraftingDevice extends RowData {
	public static String CraftingDeviceTable = "\\CraftingDevice.csv";
	public static ArrayList<CraftingDevice> craftingDevices = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("CraftingDevice", "CraftingDevice", new TableColumn("ID", ValueType.Integer), new TableColumn("Name", ValueType.String));

	String name;

	public static CraftingDevice CreateCraftingDevice(String name) {
		CraftingDevice cd = new CraftingDevice();
		cd.name = name;
		return cd;
	}

	public CraftingDevice() {
		super(CraftingDeviceTable);
		IncrementID(craftingDevices);
		craftingDevices.add(this);
	}

	public static int GetCraftingDeviceID(String name) {
		int id = -1;
		for (CraftingDevice cd : craftingDevices) {
			if (cd.name.equals(name)) {
				id = cd.ID;
				break;
			}
		}
		return id;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(name);
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(craftingDevices);
	}

}
