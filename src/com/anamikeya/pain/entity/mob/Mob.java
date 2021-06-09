package com.anamikeya.pain.entity.mob;

import com.anamikeya.pain.entity.Entity;
import com.anamikeya.pain.entity.particle.Particle;
import com.anamikeya.pain.entity.projectile.Projectile;
import com.anamikeya.pain.entity.projectile.WizardProjectile;
import com.anamikeya.pain.graphics.Sprite;

public abstract class Mob extends Entity {
	
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	
	public void move(int xa, int ya) {
		//xa and ya will tell the game in which direction the player moves
		//dir will handel the directions
		System.out.println("SIZE : "+ level.getProjectiles().size() );
		if(xa != 0 && ya!=0) { 
			//this is for sliding movement
			move(xa, 0);  
			move(0, ya);
			return;
		}
		
		
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		if(!collision(xa , ya)) {
			x += xa;
			y += ya;
		} 
		
		
		
	}
	
	public void update() {
		
	}

	
	
	public void shoot(int x, int y, double dir) {
		//dir = dir * (180 / Math.PI);		//changing into radian
		
		Projectile p = new WizardProjectile(x,y, dir);
		level.add(p);
		
		
	}
	
	public void render() {
		
	}
	
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			//checking all the corners of the tile
			int xt = ((x + xa) + c % 2 * 14 - 8 )/ 16; //2 * 2 * 10 here 10 handelsthe colision area higher the value more you wont be able to go near tiles
			int yt = ((y + ya) + c / 2 * 10 - 3) / 16;
			if(level.getTile(xt,yt).solid()) solid = true;
			
		}
		return solid;
		
	}

	
}
