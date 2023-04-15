package com.belven.rpg.items;

public class ItemData {
	public String name;
	public String mesh;
	public String icon;
	public int maxStatck;
	public ItemType type = ItemType.Resource;		

	public ItemData(String inName, String inIcon, String inMesh, int inMaxStatck) {
		name = inName;
		mesh = inMesh;
		icon= inIcon;
		maxStatck = inMaxStatck;
	}
}