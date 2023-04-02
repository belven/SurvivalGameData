package com.belven.rpg.items;

import java.util.ArrayList;

public class Item extends RowData {
	public static String Item_Table = "\\ItemData.csv";
	public static ArrayList<Item> items = new ArrayList<Item>();
	private ItemData data;

	public ItemData GetData() {
		return data;
	}

	public Item(ItemData inData) {
		super(Item_Table);
		if (items.size() > 0) {
			ID = GetLastID() + 1;
		}

		data = inData;
		items.add(this);
	}

	@Override
	public int GetLastID() {
		return items.get(items.size() - 1).ID;
	}

	public static Item CreateItem(ItemData data) {
		return new Item(data);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetData().name);
		rowData.add(GetData().type.toString());
		rowData.add(GetData().mesh);
		rowData.add(GetString(GetData().maxStatck));
		return rowData.toArray(new String[0]);
	}


}
