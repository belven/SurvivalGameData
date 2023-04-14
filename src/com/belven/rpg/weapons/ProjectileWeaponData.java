package com.belven.rpg.weapons;

public class ProjectileWeaponData {
	int rangedWeaponID;
	String projectile;
	int magazineSize;
	float reloadSpeed;
	
	public ProjectileWeaponData(String projectile, int magazineSize, float reloadSpeed) {
		this.projectile = projectile;
		this.magazineSize = magazineSize;
		this.reloadSpeed = reloadSpeed;
	}
}