package com.belven.rpg.items;

import java.util.ArrayList;

import com.belven.rpg.TableColumn;
import com.belven.rpg.TableDefinition;
import com.belven.rpg.ValueType;

public class InputOutputData extends RowData {
	public static String InputOutputTable = "\\InputOutputData.csv";
	public static ArrayList<InputOutputData> inputOutputs = new ArrayList<>();

	public static TableDefinition Table_Definition = new TableDefinition("InputOutputData", "Recipe", new TableColumn("ID", ValueType.Double), new TableColumn("inputOutputID", ValueType.Integer),
			new TableColumn("amount", ValueType.Double), new TableColumn("type", ValueType.Enumeration, InputOutputType.class.getSimpleName()),
			new TableColumn("inputOrOutput", ValueType.Enumeration, InputOrOutput.class.getSimpleName()));

	int ID;
	int inputOutputID;
	int amount;
	InputOutputType type;
	InputOrOutput inputOrOutput;

	public InputOutputData() {
		super(InputOutputTable);
		if (inputOutputs.size() > 0) {
			ID = GetLastID() + 1;
		}

		inputOutputs.add(this);
	}

	public static InputOutputData CreateInputOutputData(String typeName, int amount, InputOutputType type, InputOrOutput inputOrOutput) {
		InputOutputData data = new InputOutputData();
		data.type = type;
		data.amount = amount;
		data.inputOrOutput = inputOrOutput;

		switch (type) {
		case Gas:
			break;
		case Item:
			data.inputOutputID = Item.GetItemByName(typeName);
			break;
		case Liquid:
			break;
		case Power:
			break;
		default:
			break;
		}
		return data;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(inputOutputID));
		rowData.add(GetString(amount));
		rowData.add(type.toString());
		rowData.add(inputOrOutput.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return inputOutputs.get(inputOutputs.size() - 1).ID;
	}

}
