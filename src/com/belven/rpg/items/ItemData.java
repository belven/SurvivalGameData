package com.belven.rpg.items;

public class ItemData {
	public String name;
	public String mesh;
	public String icon;
	public int maxStatck;
	public ItemType type = ItemType.Resource;

	static String iconFolder = "Texture2D'/Game/FirstPerson/Icons/";
	static String weaponsMeshFolder = "StaticMesh'/Game/FirstPerson/Weapons/";

	public ItemData(String inName, int inMaxStatck) {
		name = inName;
		mesh = weaponsMeshFolder + inName + "." + inName + "'";
		icon = iconFolder + inName + "." + inName + "'";
		maxStatck = inMaxStatck;
	}

	public ItemData(String inName, String inIcon, String inMesh, int inMaxStatck) {
		name = inName;
		mesh = inMesh;
		icon = inIcon;
		maxStatck = inMaxStatck;
	}
	
	public ItemData(String inName, String inIcon, String inMesh, int inMaxStatck, ItemType inType) {
		name = inName;
		mesh = inMesh;
		icon = inIcon;
		maxStatck = inMaxStatck;
		type = inType;
	}
}