package com.belven.rpg.items;

import com.belven.rpg.TableDefinition;

public abstract class RowData {
	public int ID;
	public static String COMMA = ",";
	public String tableName;
	public TableDefinition tableDef;

	public RowData(String inTableName) {
		tableName = inTableName;
	}

	public abstract String[] CreateData();

	public abstract int GetLastID();

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
}