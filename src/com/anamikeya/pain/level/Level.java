package com.anamikeya.pain.level;

import java.util.ArrayList;
import java.util .List;

import com.anamikeya.pain.entity.Entity;
import com.anamikeya.pain.entity.particle.Particle;
import com.anamikeya.pain.entity.projectile.Projectile;
import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel("/levels/spawnlevel.png");
	
	private List<Entity> entities = new ArrayList<Entity>();
	public List<Projectile> projectiles = new ArrayList<Projectile>();
	public List<Particle> particles = new ArrayList<Particle>();
	
	
	public Level(int width, int height) {
		this.width = width ;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	
		
	}
	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
		
	}
	
	protected void generateLevel() {
		
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		remove();
	}
	private void remove() {
		for(int i = 0; i < entities.size(); i++) {
			if( entities.get(i).isRemoved()) entities.remove(i);
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for(int i = 0; i < particles.size(); i++) {
			if(particles.get(i).isRemoved()) particles.remove(i);
		}
	}
	private void time() {
		
	}
	
	public boolean tileCollision(int x, int y,  int size, int xOffset, int yOffset) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			//checking all the corners of the tile
			int xt = (x - c % 2 * size + xOffset) >> 4;          //2 * 2 * 10 here 10 handelsthe colision area higher the value more you wont be able to go near tiles
			int yt = (y - c / 2 * size + yOffset) >> 4;
			
			if(getTile(xt, yt).solid()) solid = true;
			
		}
		return solid;
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll  >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1; y++ ) {
			for(int x = x0; x < x1; x++) {
				getTile(x,y).render(x, y, screen);
				
			}
		}
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
		
	}
	
	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	public void add(Entity e) {
		e.init(this);
		if(e instanceof Particle) {
			particles.add((Particle) e);
		} else if(e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else{
			entities.add(e);
		}
	}
	
	
	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}
	//Grass = 0xFF00
	//hedges = 0xff0000
	//
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
	
		if(tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if(tiles[x + y * width] == Tile.col_spawn_hedge) return Tile.spawn_hedge;
		if(tiles[x + y * width] == Tile.col_spawn_floor) return Tile.spawn_floor;
		if(tiles[x + y * width] == Tile.col_spawn_wall2) return Tile.spawn_wall2;
		if(tiles[x + y * width] == Tile.col_spawn_wall1) return Tile.spawn_wall;
		if(tiles[x + y * width] == Tile.col_spawn_water) return Tile.spawn_water;
		
		
		return Tile.voidTile;
	}
	
	
}
