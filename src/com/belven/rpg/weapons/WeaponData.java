package com.belven.rpg.weapons;

import com.belven.rpg.items.GearType;

public class WeaponData {
	int itemID;
	float range;
	float healthChange;
	float useRate;
	boolean heals;
	WeaponType type;		
	GearType gearType;

	public WeaponData( float range, float healthChange, float useRate, boolean heals, GearType gearType) {
		this.range = range;
		this.healthChange = healthChange;
		this.useRate = useRate;
		this.heals = heals;
		this.gearType = gearType;
	}
}