package org.display;

import org.entities.Entity;
import org.game.Game;
import org.world.World;
import org.Tiles.Tile;
import org.display.Handler;

public class GameCamera {

	private float xOffset, yOffset;
	private Handler handler;
	public GameCamera(Handler handler, float xOffset, float yOffest) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffest;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		} else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset =  handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
		
		
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}

	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffest() {
		return yOffset;
	}

	public void setyOffest(float yOffest) {
		this.yOffset = yOffest;
	}
	
}
