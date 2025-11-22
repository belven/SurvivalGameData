package com.belven.rpg;

public class Point {
	public int x;
	public int y;
	public int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return x + ";" + y + ";" + z;
	}
}