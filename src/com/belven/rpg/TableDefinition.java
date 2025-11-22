package com.belven.rpg;

public class TableDefinition {

	String name;
	String category;
	TableColumn[] columns;
	static String newLine = "\r\n";

	public TableDefinition(String name, String category, TableColumn... columns) {
		this.name = name;
		this.category = category;
		this.columns = columns;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		value.append("------ " + name + " ------");
		value.append(newLine);
		value.append("------ Struct ------");
		value.append(newLine + newLine);
		value.append(GetCPPStruct());
		value.append(newLine + newLine);
		value.append("------ Header ------");
		value.append(newLine + newLine);
		value.append(GetCPPTableHeader());
		value.append(newLine + newLine);
		value.append("------ Class ------");
		value.append(newLine + newLine);
		value.append(GetCPPTableClass());
		value.append(newLine + newLine);
		return value.toString();
	}

	public String GetCPPTableClass() {
		StringBuilder value = new StringBuilder();
		String structName = "F" + name;
		String tableName = "U" + name + "Table";
		String indexPP = "row[index++]";

		value.append(tableName + "::" + tableName + "() : Super()");
		value.append(newLine);
		value.append("{");
		value.append(newLine);
		value.append("path = CSVT::GetTableFilePath(\"" + name + ".csv\");");
		value.append(newLine);
		value.append("}");
		value.append(newLine);
		value.append("void " + tableName + "::" + "LoadData(TArray<TArray<FString>> inDataStrings)");
		value.append(newLine);
		value.append("{");
		value.append(newLine);
		value.append("for (TArray<FString> row : inDataStrings)");
		value.append(newLine);
		value.append("{");
		value.append(newLine);
		value.append("int index = 0;");
		value.append(newLine);
		value.append(structName + " data;");
		value.append(newLine);

		for (TableColumn col : columns) {
			value.append("data." + col.name + " = ");

			switch (col.type) {
			case Float:
				value.append("GetFloatFromString(" + indexPP + ");");
				break;
			case Enumeration:
				value.append("UItemStructs::Get" + col.typeOverride + "(" + indexPP + ");");
				break;
			case Integer:
				value.append("GetIntFromString(" + indexPP + ");");
				break;
			case String:
				value.append("*" + indexPP + ";");
				break;
			case Vector:
				value.append("GetVectorFromString(" + indexPP + ");");
				break;
			case Boolean:
				value.append("UItemStructs::GetBoolean(" + indexPP + ");");
				break;
			default:
				break;

			}
			value.append(newLine);
		}

		value.append(name + ".Add(data);");
		value.append(newLine);
		value.append("}");
		value.append(newLine);
		value.append("}");

		return value.toString();
	}

	public String GetCPPTableHeader() {
		StringBuilder value = new StringBuilder("public:");
		String structName = "F" + name;
		String tableName = "U" + name + "Table";
		String arrayString = "TArray<" + structName + ">";

		value.append(newLine);
		value.append(tableName + "();");
		value.append(newLine);
		value.append("virtual void LoadData(TArray<TArray<FString>> inDataStrings) override;");
		value.append(newLine);
		value.append("private:");
		value.append(newLine);
		value.append(arrayString + " " + name + ";");
		value.append(newLine);
		value.append("public:");
		value.append(newLine);
		value.append(arrayString + "&" + " GetData()");
		value.append(newLine);
		value.append("{");
		value.append(newLine);
		value.append("return " + name + ";");
		value.append(newLine);
		value.append("}");

		return value.toString();
	}

	public String GetCPPStruct() {
		String uProperty = "UPROPERTY(EditAnywhere, BlueprintReadWrite, Category = \"" + category + "\")";

		StringBuilder value = new StringBuilder("USTRUCT(BlueprintType)" + newLine + "struct ");
		value.append("F" + name);
		value.append(newLine);
		value.append("{");
		value.append(newLine);
		value.append("GENERATED_USTRUCT_BODY()");
		value.append(newLine);
		value.append(newLine);

		for (TableColumn col : columns) {
			value.append(uProperty);
			value.append(newLine);
			value.append(col.GetAttributeCPP());
			value.append(newLine);
		}
		value.append("};");

		return value.toString();
	}
}