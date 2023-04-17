package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.items.Item;
import com.belven.rpg.items.RowData;

public class MissionItems extends RowData {
	public MissionItemData data;

	public static String MissonTable = "\\MissionItemData.csv";
	public static ArrayList<MissionItems> MissionItems = new ArrayList<>();

	public MissionItems(MissionItemData data) {
		super(MissonTable);

		this.data = data;

		if (MissionItems.size() > 0) {
			ID = GetLastID() + 1;
		}

		MissionItems.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(GetItemByName(data.itemName)));
		rowData.add(data.type.toString());
		return rowData.toArray(new String[0]);
	}

	public int GetItemByName(String name) {
		for (Item i : Item.items) {
			if (i.GetData().name.equals(name))
				return i.ID;
		}

		return -1;
	}

	@Override
	public int GetLastID() {
		return MissionItems.get(MissionItems.size() - 1).ID;
	}

	public MissionItemData getData() {
		return data;
	}

	public static MissionItems CreateMissonItem(MissionItemData md) {
		return new MissionItems(md);
	}

}
