package com.belven.rpg.items;

import java.util.ArrayList;

public abstract class RowData {
	public int ID;
	public static String COMMA = ",";
	public String tableName;

	public RowData(String inTableName) {
		tableName = inTableName;
	}

	public abstract String[] CreateData();

	public abstract int GetLastID();

	public void IncrementID(ArrayList<?> list) {
		if (list.size() > 0) {
			ID = GetLastID() + 1;
		}
	}

	public String GetString(float value) {
		String s = String.valueOf(value);
		return s.replace("\"", "");
	}

	public String GetString(int value) {
		String s = String.valueOf(value);
		return s.replace("\"", "");
	}

	public String GetString(boolean value) {
		String s = String.valueOf(value);
		return s.replace("\"", "");
	}

	public int GetLastID(ArrayList<? extends RowData> list) {
		return list.get(list.size() - 1).ID;
	}
}