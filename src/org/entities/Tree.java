package org.entities;

import java.awt.Graphics;

import org.Tiles.Tile;
import org.display.Handler;
import org.images.Assets;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffest()), null);
		
	}

	
	
}
