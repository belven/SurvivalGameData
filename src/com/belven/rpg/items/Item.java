package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class Item extends RowData {
	public static String TableName = "\\ItemData.csv";
	public static ArrayList<Item> Data = new ArrayList<Item>();
	private ItemData data;

	public static TableDefinition Table_Definition = new TableDefinition("Item", "Item", new TableColumn("ID", ValueType.Integer), new TableColumn("Name", ValueType.String),
			new TableColumn("Mesh", ValueType.String), new TableColumn("Icon", ValueType.String), new TableColumn("MaxStackSize", ValueType.Integer),
			new TableColumn("Type", ValueType.Enumeration, ItemType.class.getSimpleName()));

	public ItemData GetData() {
		return data;
	}

	public Item(ItemData inData) {
		super(TableName);
		IncrementID(Data);
		data = inData;
		Data.add(this);
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

	public static Item CreateItem(ItemData data) {
		return new Item(data);
	}

	public static int GetItemByName(String name) {
		for (Item i : Item.Data) {
			if (i.GetData().name.equals(name))
				return i.ID;
		}

		System.out.println("Item not found " + name);
		return -1;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetData().name);
		rowData.add(GetData().type.toString());
		rowData.add(GetData().icon);
		rowData.add(GetData().mesh);
		rowData.add(GetString(GetData().maxStatck));
		return rowData.toArray(new String[0]);
	}
}
