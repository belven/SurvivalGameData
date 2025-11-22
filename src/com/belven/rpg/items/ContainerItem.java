package com.belven.rpg.items;

import java.util.ArrayList;

public class ContainerItem extends RowData {

	public static String ContainerItemTable = "\\ContainerItems.csv";
	public static ArrayList<ContainerItem> ContainerItems = new ArrayList<>();

	String containerName;
	String itemName;

	public ContainerItem(String containerName, String itemName) {
		super(ContainerItemTable);
		this.containerName = containerName;
		this.itemName = itemName;

		IncrementID(ContainerItems);

		ContainerItems.add(this);
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
		return GetLastID(ContainerItems);
	}

}
