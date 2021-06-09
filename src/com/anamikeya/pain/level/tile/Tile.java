package com.anamikeya.pain.level.tile;

import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.graphics.Sprite;
import com.anamikeya.pain.level.tile.spawnlevel.SpawnGrassTile;
import com.anamikeya.pain.level.tile.spawnlevel.SpawnHedgeTile;
import com.anamikeya.pain.level.tile.spawnlevel.SpawnRockTile;
import com.anamikeya.pain.level.tile.spawnlevel.SpawnWallTile;
import com.anamikeya.pain.level.tile.spawnlevel.SpawnWallTile2;
import com.anamikeya.pain.level.tile.spawnlevel.SpawnWaterTile;

public class Tile {
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile   = new VoidTile(Sprite.voidSprite);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile baserock = new BaseRockTile(Sprite.baserock);
	public static Tile highbush = new HighBush(Sprite.highbush);
	
	//spawn Level Tiles
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);  
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);  
	public static Tile spawn_wall = new SpawnWallTile(Sprite.spawn_wall_1);  
	public static Tile spawn_wall2 = new SpawnWallTile2(Sprite.spawn_wall_2);  
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_floor = new SpawnRockTile(Sprite.spawn_floor);  
	
	public final static int col_spawn_grass = 0xff00ff00;
	public final static int col_spawn_hedge = 0xffFFFF00;
	public final static int col_spawn_water = 0xff00FFF0;
	public final static int col_spawn_wall1 = 0xff7F7F00;
	public final static int col_spawn_wall2 = 0xff000000;
	public final static int col_spawn_floor = 0xffFF0000;
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
}
