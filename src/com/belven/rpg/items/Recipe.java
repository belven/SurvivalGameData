package com.belven.rpg.items;

import java.util.ArrayList;

public class Recipe extends RowData {
	public static String RecipeTable = "\\RecipeData.csv";
	public static ArrayList<Recipe> recipes = new ArrayList<>();

	String name;
	int craftingDeviceID;
	RecipeType type;

	public Recipe() {
		super(RecipeTable);
		if (recipes.size() > 0) {
			ID = GetLastID() + 1;
		}

		recipes.add(this);
	}

	public static Recipe CreateRecipe(String name, RecipeType type, int craftingDeviceID, InputOutputData... inputOutputData) {
		Recipe data = new Recipe();
		data.name = name;
		data.type = type;
		data.craftingDeviceID = craftingDeviceID;

		for (InputOutputData ioData : inputOutputData) {
			RecipeInputOutputData.CreateRecipeInputOutputData(data.ID, ioData.ID);
		}

		return data;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(name);
		rowData.add(type.toString());
		rowData.add(GetString(craftingDeviceID));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return recipes.get(recipes.size() - 1).ID;
	}

}
