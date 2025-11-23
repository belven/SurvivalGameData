package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class RecipeInputOutputData extends RowData {
	public static String TableName = "\\RecipeInputOutputData.csv";
	public static ArrayList<RecipeInputOutputData> Data = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("RecipeInputOutputData", "RecipeInputOutputData", new TableColumn("ID", ValueType.Integer),
			new TableColumn("RecipeID", ValueType.Integer), new TableColumn("InputOutputDataID", ValueType.Integer));

	int recipeID;
	int inputOutputDataID;

	public RecipeInputOutputData() {
		super(TableName);
		IncrementID(Data);
		Data.add(this);
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
		return GetLastID(Data);
	}

}
