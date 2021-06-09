package com.anamikeya.pain.level;

import java.util.Random;

public class RandomLavel extends Level {

	private static final Random random = new Random(); 
	
	public RandomLavel(int width, int height) {
		super(width, height);
		
	}

	protected void generateLevel() {
		for(int y=0; y < height; y++) {
			for(int x= 0; x < width; x++){
				tilesInt[x+y*width] = random.nextInt(4);
			}
		}
		
	}
	
	
	
}
