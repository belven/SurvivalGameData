package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class Recipe extends RowData {
	public static String RecipeTable = "\\RecipeData.csv";
	public static ArrayList<Recipe> recipes = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("CraftingDevice", "CraftingDevice", new TableColumn("ID", ValueType.Integer), new TableColumn("Name", ValueType.String),
			new TableColumn("CraftingTime", ValueType.Double));

	String name;
	RecipeType type;
	float craftingTime;

	public Recipe() {
		super(RecipeTable);
		IncrementID(recipes);
		recipes.add(this);
	}

	public static Recipe CreateRecipe(String name, RecipeType type, float craftingTime, InputOutputData... inputOutputData) {
		Recipe data = new Recipe();
		data.name = name;
		data.type = type;
		data.craftingTime = craftingTime;

		for (InputOutputData ioData : inputOutputData) {
			RecipeInputOutputData.CreateRecipeInputOutputData(data.ID, ioData.ID);
		}

		return data;
	}

	public static int GetRecipeID(String name) {
		int id = -1;
		for (Recipe r : recipes) {
			if (r.name.equals(name)) {
				id = r.ID;
				break;
			}
		}
		return id;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(name);
		rowData.add(type.toString());
		rowData.add(GetString(craftingTime));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return GetLastID(recipes);
	}

}
