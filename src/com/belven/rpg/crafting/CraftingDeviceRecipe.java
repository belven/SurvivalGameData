package com.belven.rpg.crafting;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;
import com.belven.rpg.items.Recipe;
import com.belven.rpg.items.RowData;

public class CraftingDeviceRecipe extends RowData {
	public static String TableName = "\\CraftingDeviceRecipe.csv";
	public static ArrayList<CraftingDeviceRecipe> Data = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("CraftingDeviceRecipes", "CraftingDeviceRecipes", new TableColumn("ID", ValueType.Integer),
			new TableColumn("CraftingDeviceID", ValueType.Integer), new TableColumn("RecipeID", ValueType.Integer));

	String craftingDeviceName;
	String recipeName;

	public static CraftingDeviceRecipe CreateCraftingDeviceRecipe(String craftingDeviceName, String recipeName) {
		CraftingDeviceRecipe cdr = new CraftingDeviceRecipe();
		cdr.craftingDeviceName = craftingDeviceName;
		cdr.recipeName = recipeName;
		return cdr;
	}

	public CraftingDeviceRecipe() {
		super(TableName);
		IncrementID(Data);
		Data.add(this);
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(CraftingDevice.GetCraftingDeviceID(craftingDeviceName)));
		rowData.add(GetString(Recipe.GetRecipeID(recipeName)));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(Data);
	}

}
