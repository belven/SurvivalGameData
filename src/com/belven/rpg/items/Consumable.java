package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class Consumable extends RowData {
	public static String Consumable_Table = "\\ConsumableData.csv";
	public static ArrayList<Consumable> Consumables = new ArrayList<Consumable>();
	private ConsumableData data;

	public static TableDefinition Table_Definition = new TableDefinition("Consumable", "Consumable", new TableColumn("ID", ValueType.Integer), new TableColumn("ItemID", ValueType.Integer),
			new TableColumn("ConsumableType", ValueType.Enumeration, ConsumableType.class.getSimpleName()), new TableColumn("Vale", ValueType.Integer));

	public ConsumableData GetData() {
		return data;
	}

	public Consumable(ConsumableData inData) {
		super(Consumable_Table);
		IncrementID(Consumables);
		data = inData;
		Consumables.add(this);
	}

	@Override
	public int GetLastID() {
		return GetLastID(Consumables);
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