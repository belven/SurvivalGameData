package com.belven.rpg.items;

public class ItemData {
	protected String name;
	protected String mesh;
	protected int maxStatck;
	protected ItemType type;		

	public ItemData(String inName, String inMesh, int inMaxStatck) {
		name = inName;
		mesh = inMesh;
		maxStatck = inMaxStatck;
	}
}