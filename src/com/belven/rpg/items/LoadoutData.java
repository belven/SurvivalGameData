package com.belven.rpg.items;

public class LoadoutData {
	public int entityID;
	
	public int weaponID;
	public int headArmourID;
	public int chestArmourID;
	public int leftLegArmourID;
	public int rightLegArmourID;
	public int leftArmArmourID;
	public int rightArmArmourID;
	
	public int abilityOneID;
	public int abilityTwoID;
	public int abilityThreeID;

	public int health;
	public int moveSpeed;
	
	public CharacterType type;
	
	public LoadoutData(int entityID, int weaponID, int headArmourID, int chestArmourID, int leftLegArmourID,
			int rightLegArmourID, int leftArmArmourID, int rightArmArmourID, int abilityOneID, int abilityTwoID,
			int abilityThreeID, int health, int moveSpeed, CharacterType type) {
		super();
		this.entityID = entityID;
		this.weaponID = weaponID;
		this.headArmourID = headArmourID;
		this.chestArmourID = chestArmourID;
		this.leftLegArmourID = leftLegArmourID;
		this.rightLegArmourID = rightLegArmourID;
		this.leftArmArmourID = leftArmArmourID;
		this.rightArmArmourID = rightArmArmourID;
		this.abilityOneID = abilityOneID;
		this.abilityTwoID = abilityTwoID;
		this.abilityThreeID = abilityThreeID;
		this.health = health;
		this.moveSpeed = moveSpeed;
		this.type = type;
	} 
}