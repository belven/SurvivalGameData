package com.belven.rpg.items;

public class WeaponData {
	int itemID;
	float range;
	float healthChange;
	float useRate;
	boolean heals;
	WeaponType type;		


	public WeaponData( float range, float healthChange, float useRate, boolean heals) {
		this.range = range;
		this.healthChange = healthChange;
		this.useRate = useRate;
		this.heals = heals;
	}
}