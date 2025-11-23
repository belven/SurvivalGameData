package com.belven.rpg.mission;

import java.util.ArrayList;

import com.belven.rpg.items.Item;
import com.belven.rpg.items.RowData;

public class MissionItems extends RowData {
	public MissionItemData data;

	public static String TableName = "\\MissionItemData.csv";
	public static ArrayList<MissionItems> Data = new ArrayList<>();

	public MissionItems(MissionItemData data) {
		super(TableName);

		this.data = data;

		if (Data.size() > 0) {
			ID = GetLastID() + 1;
		}

		Data.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(Item.GetItemByName(data.itemName)));
		rowData.add(data.type.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return Data.get(Data.size() - 1).ID;
	}

	public MissionItemData getData() {
		return data;
	}

	public static MissionItems CreateMissonItem(MissionItemData md) {
		return new MissionItems(md);
	}

}
