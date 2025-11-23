package com.belven.rpg.crafting;

import java.util.ArrayList;

import com.belven.rpg.Point;
import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.OwnerType;
import com.belven.rpg.items.RowData;

public class InstanceCraftingDevice extends RowData {

	public static String TableName = "\\InstanceCraftingDevice.csv";
	public static ArrayList<InstanceCraftingDevice> Data = new ArrayList<>();
	public static TableDefinition Table_Definition = new TableDefinition("InstanceCraftingDevice", "InstanceCraftingDevice", new TableColumn("ID", ValueType.Integer),
			new TableColumn("CraftingDeviceID", ValueType.Integer), new TableColumn("Location", ValueType.Vector), new TableColumn("OwnerID", ValueType.Integer),
			new TableColumn("OwnerType", ValueType.Enumeration, OwnerType.class.getSimpleName()));

	int craftingDeviceID;
	Point location;
	int ownerID;
	OwnerType ownerType;

	public static InstanceCraftingDevice CreateInstanceCraftingDevice(int craftingDeviceID, Point location, int ownerID, OwnerType ownerType) {
		InstanceCraftingDevice icd = new InstanceCraftingDevice();

		icd.craftingDeviceID = craftingDeviceID;
		icd.location = location;
		icd.ownerID = ownerID;
		icd.ownerType = ownerType;
		return icd;
	}

	public InstanceCraftingDevice() {
		super(TableName);
		IncrementID(Data);
		Data.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(craftingDeviceID));
		rowData.add(location.toString());
		rowData.add(GetString(ownerID));
		rowData.add(ownerType.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

}
