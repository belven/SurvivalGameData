package com.belven.rpg.items;

public class ItemData {
	public String name;
	public String mesh;
	public int maxStatck;
	public ItemType type = ItemType.Resource;		

	public ItemData(String inName, String inMesh, int inMaxStatck) {
		name = inName;
		mesh = inMesh;
		maxStatck = inMaxStatck;
	}
}