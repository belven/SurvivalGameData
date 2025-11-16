package com.belven.rpg;

public class TableColumn {

	String name = "";
	ValueType type;
	String typeOverride = "";

	public TableColumn(String name, ValueType type, String typeOverride) {
		this.typeOverride = typeOverride;
		this.name = name;
		this.type = type;
	}

	public TableColumn(String name, ValueType type) {
		this.name = name;
		this.type = type;
	}

	String GetAttributeCPP() {
		String typeString = typeOverride.isEmpty() ? GetTypeString() : typeOverride;
		if (type == ValueType.Enumeration) {
			typeString = "E" + typeString;
		}
		return typeString + " " + name + ";";
	}

	String GetTypeString() {
		switch (type) {
		case Double:
			return "float";
		case Integer:
			return "int32";
		case String:
			return "FString";
		default:
			break;

		}
		return "Not Found";
	}

}
