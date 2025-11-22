package com.belven.rpg.crafting;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.RowData;

public class InProgressCrafting extends RowData {

	public static String InProgressCraftingTable = "\\InProgressCrafting.csv";
	public static ArrayList<InProgressCrafting> inProgressCraftingData = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("InProgressCrafting", "InProgressCrafting", new TableColumn("ID", ValueType.Integer),
			new TableColumn("InstanceCraftingDeviceID", ValueType.Integer), new TableColumn("RecipeID", ValueType.Integer), new TableColumn("QueuePosition", ValueType.Integer),
			new TableColumn("Progress", ValueType.Double));

	int instanceCraftingDeviceID;
	int recipeID;
	int queuePosition;
	float progress;

	static public InProgressCrafting CreateInProgressCrafting(int instanceCraftingDeviceID, int recipeID, int queuePosition, float progress) {
		InProgressCrafting ipc = new InProgressCrafting();
		ipc.instanceCraftingDeviceID = instanceCraftingDeviceID;
		ipc.recipeID = recipeID;
		ipc.queuePosition = queuePosition;
		ipc.progress = progress;
		return ipc;
	}

	public InProgressCrafting() {
		super(InProgressCraftingTable);
		IncrementID(inProgressCraftingData);
		inProgressCraftingData.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(instanceCraftingDeviceID));
		rowData.add(GetString(recipeID));
		rowData.add(GetString(queuePosition));
		rowData.add(GetString(progress));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(inProgressCraftingData);
	}

}
