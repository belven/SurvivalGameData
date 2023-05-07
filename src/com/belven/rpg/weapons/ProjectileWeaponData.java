package com.belven.rpg.weapons;

public class ProjectileWeaponData {
	int rangedWeaponID;
	String ammoType;
	int magazineSize;
	float reloadSpeed;
	int bulletVelocity;
	
	public ProjectileWeaponData(String ammoType, int magazineSize, float reloadSpeed, int bulletVelocity) {
		this.ammoType = ammoType;
		this.magazineSize = magazineSize;
		this.reloadSpeed = reloadSpeed;
		this.bulletVelocity = bulletVelocity;
	}
}