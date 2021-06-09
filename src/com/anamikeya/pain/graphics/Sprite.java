package com.anamikeya.pain.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	private SpriteSheet sheet;
	public int[] pixels;
	private int width, height;
	
	public static Sprite voidSprite = new Sprite(16, 0x00abff); 
	public static Sprite grass = new Sprite(16, 10, 1, SpriteSheet.tiles);
	public static Sprite flower =  new Sprite(16, 12, 1, SpriteSheet.tiles);
	public static Sprite rock =  new Sprite(16, 10, 4, SpriteSheet.tiles);
	public static Sprite baserock =  new Sprite(16, 13, 1, SpriteSheet.tiles);
	public static Sprite highbush = new Sprite(16, 15, 1, SpriteSheet.tiles);
	
	//spawn level Sprite here
	public static Sprite spawn_grass = new Sprite(16,0,0,SpriteSheet.spawntiles);
	public static Sprite spawn_hedge = new Sprite(16,1,0,SpriteSheet.spawntiles);
	public static Sprite spawn_water = new Sprite(16,2,0,SpriteSheet.spawntiles);
	public static Sprite spawn_wall_1= new Sprite(16,0,1,SpriteSheet.spawntiles);
	public static Sprite spawn_wall_2 = new Sprite(16,0,2,SpriteSheet.spawntiles);
	public static Sprite spawn_floor= new Sprite(16,1,1,SpriteSheet.spawntiles);
	
	
	//player Sprites
	public static Sprite player_forward =  new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_back =  new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_side =  new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite player_forward_1 = new Sprite (32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite (32, 2, 6, SpriteSheet.tiles);
	
	public static Sprite player_back_1 = new Sprite (32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite (32, 2, 5, SpriteSheet.tiles);
	
	public static Sprite player_side_1 = new Sprite (32, 1, 7, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite (32, 2, 7, SpriteSheet.tiles);
	
	//projectile Sprite
	public static Sprite bullet_wizard = new Sprite(16, 1, 0,SpriteSheet.projectiles);
	
	//Particles
	public static Sprite particle_normal = new Sprite(3, 0xabff89);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
		
	}
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height =height;
		pixels = new int[width * height];
		setColour(color);
		
	}
	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
		
		
	}
	private void setColour(int colour) {
		for(int i = 0; i < width*height; i++) {
			pixels[i] = colour;
		}
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x+ this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
