package com.anamikeya.pain.level.tile;

import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen) {
		//Do render stuff here
		
		screen.renderTile(x<<4, y<<4, this);
		
	}


}
