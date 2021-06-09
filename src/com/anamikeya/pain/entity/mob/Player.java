package com.anamikeya.pain.entity.mob;

import com.anamikeya.pain.Game;
import com.anamikeya.pain.entity.projectile.Projectile;
import com.anamikeya.pain.entity.projectile.WizardProjectile;
import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.graphics.Sprite;
import com.anamikeya.pain.input.Keyboard;
import com.anamikeya.pain.input.Mouse;

public class Player extends Mob {
	
	private Projectile projectile;
	private Sprite sprite;
	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;
	private int fireRate = 0;
	public Player(Keyboard input) {
		this.input = input;
		
	}
	
	public Player(int x, int y ,Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = WizardProjectile.FIRE_RATE;
		}
	
	public void update() {
		if(fireRate > 0) fireRate--;
		
		int xa =0, ya = 0;
		if(anim  < 7500) anim++;
		else anim = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
	
		if(xa != 0 ||ya != 0 ) {
			walking = true;
			move(xa,ya);
		}
		else {
			walking = false;
		}
		clear();
		updateShooting();		
}
	
	private void clear() {
		for(int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	
	protected void updateShooting() {
		
		if(Mouse.getButton() ==  1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			
			shoot(x,y,dir);
			fireRate = WizardProjectile.FIRE_RATE;
			
		}
	}
	protected void keyboardShooting() {
		if(input.space) {
			if(dir == 0) {
				projectile.ny++;
			}
			if(dir == 0) {
				projectile.nx++;
			}
			
			
		}
	}
	
	
	public void render(Screen screen) {
		int flip = 0;
		if(dir == 0) {
			sprite = Sprite.player_forward;
			if(walking) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_forward_1;
				}
				else {
					sprite = Sprite.player_forward_2;
				}
			}
		}
		if(dir == 1 ) {
			sprite = Sprite.player_side;
			if(walking) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				}
				else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		if(dir == 2) {
			sprite = Sprite.player_back;
			if(walking) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				}
				else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		if(dir == 3) {
			sprite = Sprite.player_side;
			flip = 1;
			if(walking) {
			if(anim % 20 > 10) {
				sprite = Sprite.player_side_1;
			}
			else {
				sprite = Sprite.player_side_2;
			}
		}
	}
	
		
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
		
	}

}
