package com.anamikeya.pain.entity.projectile;

import java.util.Random;

import com.anamikeya.pain.entity.Entity;
import com.anamikeya.pain.graphics.Sprite;

public class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x,y;
	public double nx;
	public double ny;
	protected double distance;
	protected double speed, range, damage;
	
	protected final Random random = new Random();
	
	
	public Projectile(int x, int y, double dir) {
	
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void move() {
	
		
	}
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSpriteSize() {
		return sprite.SIZE;
	}
	
	

}
