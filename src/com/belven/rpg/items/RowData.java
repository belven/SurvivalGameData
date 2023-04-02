package com.belven.rpg.items;

public abstract class RowData {
	int ID;
	public static String COMMA = ",";
	public String tableName;
	
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