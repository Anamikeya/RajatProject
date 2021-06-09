package com.anamikeya.pain.entity.projectile;

import com.anamikeya.pain.entity.spawnner.ParticleSpawner;
import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 15;
	
	public WizardProjectile(int x, int y, double dir) {
		super(x, y,dir);
		// TODO Auto-generated constructor stub
		range = 200;
		damage =  20;
		speed = 4;
		sprite  = Sprite.bullet_wizard;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		if(level.tileCollision((int) (x + nx), (int) (y + ny), 7, 5 , 4)) {
			level.add(new ParticleSpawner((int) x, (int) y, 10000, 50, level));
			remove();
		}
		move();
		
	}
	
	
	
	public void move() {
		x += nx;
		y += ny;
		
		
		if(distance() >  range) remove();
	}
	
	
	
	private double distance() {
		// TODO Auto-generated method stub
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) *(yOrigin - y)));
		
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int)x - 12,(int)y - 8 , this);
	}
}
