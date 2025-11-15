package com.belven.rpg.items;

import java.util.ArrayList;

public class RecipeInputOutputData extends RowData {
	public static String RecipeInputOutputDataTable = "\\RecipeInputOutputData.csv";
	public static ArrayList<RecipeInputOutputData> RecipeInputOutputData = new ArrayList<>();

	int recipeID;
	int inputOutputDataID;

	public RecipeInputOutputData() {
		super(RecipeInputOutputDataTable);
		if (RecipeInputOutputData.size() > 0) {
			ID = GetLastID() + 1;
		}

		RecipeInputOutputData.add(this);
	}

	public static RecipeInputOutputData CreateRecipeInputOutputData(int recipeID, int inputOutputDataID) {
		RecipeInputOutputData data = new RecipeInputOutputData();
		data.inputOutputDataID = inputOutputDataID;
		data.recipeID = recipeID;
		return data;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(recipeID));
		rowData.add(GetString(inputOutputDataID));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return RecipeInputOutputData.get(RecipeInputOutputData.size() - 1).ID;
	}

}
