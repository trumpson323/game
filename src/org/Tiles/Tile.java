package org.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile rockTile = new RockTile(1);

	
	protected BufferedImage texture;
	protected final int id;
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isSolid() {
		return false;
	}
}
