package com.belven.rpg.mission;

import com.belven.rpg.items.CharacterType;

public class LoadoutData {
	public String name;	
	public String weapon;
	public String headArmour;
	public String chestArmour;
	public String legsArmour;
	public String vestArmour;

	public int health;
	public int moveSpeed;
	
	public CharacterType type;
	
	public LoadoutData(String name, String weapon, String headArmour, String chestArmour, String vest, String legsArmour,  int health, int moveSpeed, CharacterType type) {
		super();
		this.name = name;
		this.weapon = weapon;
		this.headArmour = headArmour;
		this.chestArmour = chestArmour;
		this.legsArmour = legsArmour;
		this.vestArmour = vest;
		this.health = health;
		this.moveSpeed = moveSpeed;
		this.type = type;
	} 
}