package org.world;

import java.awt.Graphics;

import org.Tiles.Tile;
import org.game.Game;
import org.utils.Utils;

public class World {

	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}

	public void update() {
		
	}
	
	public void render(Graphics g) {
		
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth())/ Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffest() / Tile.TILEHEIGHT); 
		int yEnd = (int) Math.min(width, (game.getGameCamera().getyOffest() + game.getWidth())/ Tile.TILEHEIGHT + 1);
		
		for(int y= yStart; y < yEnd; y++) {
			for(int x = xStart; x< xEnd; x++) {
				getTile(x, y).render(g, (int)( x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()) , 
						(int)(y * Tile.TILEHEIGHT - game.getGameCamera().getyOffest()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.grassTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width;x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
		
	}
	
}
