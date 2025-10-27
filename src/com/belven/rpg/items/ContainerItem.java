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

		if (ContainerItems.size() > 0) {
			ID = GetLastID() + 1;
		}

		ContainerItems.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(ContainerData.GetContainerByName(containerName)));
		rowData.add(GetString(Item.GetItemByName(itemName)));
		// rowData.add(containerName);
		// rowData.add(itemName);
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return ContainerItems.get(ContainerItems.size() - 1).ID;
	}

}
