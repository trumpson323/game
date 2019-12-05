package org.images;

import java.awt.image.BufferedImage;

import org.display.SpriteSheet;

public class Assets {

	private static final int width = 100, height = 100;
	private static final int sheetWidth = 64, sheetHeight = 64;
	
	public static BufferedImage player, stone, grass, tree;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] playerStill;
	
	
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SSpritesheet (1).png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/pokemonPlayer.png"));
		SpriteSheet trees = new SpriteSheet(ImageLoader.loadImage("/textures/LPCsnowTrees.png"));
		
		player_down = new BufferedImage[4];
		
		player_down[0] = playerSheet.crop(0, 0, 64, 64);
		player_down[1] = playerSheet.crop(sheetWidth, 0, 64, 64);
		player_down[2] = playerSheet.crop(sheetWidth * 2, 0, 64, 64);
		player_down[3] = playerSheet.crop(sheetWidth * 3, 0, 64, 64);
		
		player_left = new BufferedImage[4];
		
		player_left[0] = playerSheet.crop(0, sheetHeight, 64, 64);
		player_left[1] = playerSheet.crop(sheetWidth, sheetHeight, 64, 64);
		player_left[2] = playerSheet.crop(sheetWidth * 2, sheetHeight, 64, 64);
		player_left[3] = playerSheet.crop(sheetWidth * 3, sheetHeight, 64, 64);
		
		player_right = new BufferedImage[4];
		
		player_right[0] = playerSheet.crop(0, sheetHeight * 2, 64, 64);
		player_right[1] = playerSheet.crop(sheetWidth, sheetHeight * 2, 64, 64);
		player_right[2] = playerSheet.crop(sheetWidth * 2, sheetHeight * 2, 64, 64);
		player_right[3] = playerSheet.crop(sheetWidth * 3, sheetHeight * 2, 64, 64);
		
		player_up = new BufferedImage[4];
		
		player_up[0] = playerSheet.crop(0, sheetHeight * 3, 64, 64);
		player_up[1] = playerSheet.crop(sheetWidth, sheetHeight * 3, 64, 64);
		player_up[2] = playerSheet.crop(sheetWidth * 2, sheetHeight * 3, 64, 64);
		player_up[3] = playerSheet.crop(sheetWidth * 3, sheetHeight * 3, 64, 64);
		
		
		playerStill = new BufferedImage[4];
		
		playerStill[0] = player_up[0];
		playerStill[1] = player_down[0];
		playerStill[2] = player_left[0];
		playerStill[3] = player_right[0];
		
		player = sheet.crop(0, width, width, height);
		stone = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		tree =  trees.crop(0, 0, 96, 128);
		
	}
	
}
