package com.belven.rpg.weapons;

public class ProjectileWeaponData {
	int rangedWeaponID;
	String projectile;
	int magazineSize;
	float reloadSpeed;
	int bulletVelocity;
	
	public ProjectileWeaponData(String projectile, int magazineSize, float reloadSpeed, int bulletVelocity) {
		this.projectile = projectile;
		this.magazineSize = magazineSize;
		this.reloadSpeed = reloadSpeed;
		this.bulletVelocity = bulletVelocity;
	}
}