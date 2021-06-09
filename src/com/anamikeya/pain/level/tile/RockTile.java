package com.anamikeya.pain.level.tile;

import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.graphics.Sprite;

public class RockTile extends Tile{

	public RockTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x <<4, y << 4, this);
	}
	
	public boolean solid() {
		return true;
	}
}
