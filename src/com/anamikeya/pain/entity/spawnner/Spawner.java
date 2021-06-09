package com.anamikeya.pain.entity.spawnner;

import com.anamikeya.pain.entity.Entity;
import com.anamikeya.pain.level.Level;

public class Spawner extends Entity {
	public enum Type{
		MOB, PARTICLE;
	}
	
	private Type type;
	
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;

	}
	
}
