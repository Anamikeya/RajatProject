package com.anamikeya.pain.level.tile.spawnlevel;

import com.anamikeya.pain.graphics.Screen;
import com.anamikeya.pain.graphics.Sprite;
import com.anamikeya.pain.level.tile.Tile;

public class SpawnRockTile extends Tile {

	public SpawnRockTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile( x << 4, y << 4, this);
	}

}
