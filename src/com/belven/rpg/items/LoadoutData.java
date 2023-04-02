package com.belven.rpg.items;

public class LoadoutData {
	public int entityID;
	
	public int weaponID;
	public int headArmourID;
	public int chestArmourID;
	public int legsArmourID;

	public int health;
	public int moveSpeed;
	
	public CharacterType type;
	
	public LoadoutData(int entityID, int weaponID, int headArmourID, int chestArmourID, int legsArmourID, int health, int moveSpeed, CharacterType type) {
		super();
		this.entityID = entityID;
		this.weaponID = weaponID;
		this.headArmourID = headArmourID;
		this.chestArmourID = chestArmourID;
		this.legsArmourID = legsArmourID;
		this.health = health;
		this.moveSpeed = moveSpeed;
		this.type = type;
	} 
}