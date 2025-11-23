package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class ContainerItem extends RowData {

	public static String TableName = "\\ContainerItems.csv";
	public static ArrayList<ContainerItem> Data = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("ContainerItem", "ContainerItem", new TableColumn("ID", ValueType.Integer), new TableColumn("ContainerID", ValueType.Integer),
			new TableColumn("ItemID", ValueType.Integer));

	String containerName;
	String itemName;

	public static ContainerItem CreateContainerItem(String containerName, String itemName) {
		ContainerItem ci = new ContainerItem();
		ci.containerName = containerName;
		ci.itemName = itemName;
		return ci;
	}

	public ContainerItem() {
		super(TableName);
		IncrementID(Data);
		Data.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(ContainerData.GetContainerByName(containerName)));
		rowData.add(GetString(Item.GetItemByName(itemName)));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

}
