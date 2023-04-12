package com.belven.rpg.items;

public class ConsumableData {
	int ItemID;
	ConsumableType conType;
	int value;
	
	public ConsumableData(ConsumableType conType, int value) {
		super();
		this.conType = conType;
		this.value = value;
	}
}