package com.anamikeya.pain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	protected final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritesheet.png", 256);
	public static SpriteSheet spawntiles = new SpriteSheet("/textures/levels/spawnlevelsheet.png", 48); 
	public static SpriteSheet projectiles = new SpriteSheet("/textures/sheets/projectiles/projectiles.png", 48); 
	
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
		
	}
	
	private void load() {
		try{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			
			image.getRGB(0, 0,w,h,pixels,0,w);
			
			} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
