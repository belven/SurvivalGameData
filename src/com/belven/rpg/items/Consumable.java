package com.belven.rpg.items;

import java.util.ArrayList;

public class Consumable extends RowData {
	public static String Consumable_Table = "\\ConsumableData.csv";
	public static ArrayList<Consumable> Consumables = new ArrayList<Consumable>();
	private ConsumableData data;

	public ConsumableData GetData() {
		return data;
	}

	public Consumable(ConsumableData inData) {
		super(Consumable_Table);
		if (Consumables.size() > 0) {
			ID = GetLastID() + 1;
		}

		data = inData;
		Consumables.add(this);
	}

	@Override
	public int GetLastID() {
		return Consumables.get(Consumables.size() - 1).ID;
	}

	public static Consumable CreateConsumable(ItemData id, ConsumableData data) {
		id.type = ItemType.Consumable;
		Item i = Item.CreateItem(id);

		data.ItemID = i.ID;
		return new Consumable(data);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(GetData().ItemID));
		rowData.add(GetData().conType.toString());
		rowData.add(GetString(GetData().value));
		return rowData.toArray(new String[0]);
	}
}