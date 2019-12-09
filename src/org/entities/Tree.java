package org.entities;

import java.awt.Color;
import java.awt.Graphics;

import org.Tiles.Tile;
import org.display.Handler;
import org.images.Assets;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		bounds.x = 28;
		bounds.y = 34;
		bounds.height = 60;
		bounds.width = 40;
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffest()), null);
		
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffest()), bounds.width, bounds.height);
	}

	
	
}
