package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class Armour extends RowData {
	public static String ArmourTable = "\\ArmourData.csv";
	public static ArrayList<Armour> armour = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("Armour", "Armour", new TableColumn("ID", ValueType.Integer), new TableColumn("ItemID", ValueType.Integer),
			new TableColumn("ContainerID", ValueType.Integer), new TableColumn("ArmourPosition", ValueType.Enumeration, ArmourPosition.class.getSimpleName()),
			new TableColumn("resistance", ValueType.Integer));

	int itemID;
	int containerID;
	ArmourPosition armourPosition;
	int resistance;

	public Armour() {
		super(ArmourTable);
		IncrementID(armour);
		armour.add(this);
	}

	public static Armour CreateArmour(ItemData itemData, ArmourPosition armourPosition, int containerID) {
		return CreateArmour(itemData, armourPosition, containerID, 0);
	}

	public static Armour CreateArmour(ItemData itemData, ArmourPosition armourPosition, int containerID, int resistance) {
		itemData.type = ItemType.Armour;
		Item i = Item.CreateItem(itemData);

		Armour a = new Armour();
		a.itemID = i.ID;
		a.armourPosition = armourPosition;
		a.resistance = resistance;
		a.containerID = containerID;
		return a;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(itemID));
		rowData.add(GetString(containerID));
		rowData.add(armourPosition.toString());
		rowData.add(GetString(resistance));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(armour);
	}

}
