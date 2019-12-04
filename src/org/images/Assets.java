package org.images;

import java.awt.image.BufferedImage;

import org.display.SpriteSheet;

public class Assets {

	private static final int width = 100, height = 100;
	private static final int sheetWidth = 64, sheetHeight = 64;
	
	public static BufferedImage player, stone, grass;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage playerStill;
	
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SSpritesheet (1).png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/goblin.png"));
		
		player_down = new BufferedImage[7];
		
		player_down[0] = playerSheet.crop(0, 0, 64, 64);
		player_down[1] = playerSheet.crop(sheetWidth * 2, 0, 64, 64);
		player_down[2] = playerSheet.crop(sheetWidth * 3 + 5, 0, 64, 64);
		player_down[3] = playerSheet.crop(sheetWidth * 4 + 5, 0, 64, 64);
		player_down[4] = playerSheet.crop(sheetWidth * 5 + 5, 0, 64, 64);
		player_down[5] = playerSheet.crop(sheetWidth * 6 + 5, 0, 64, 64);
		player_down[6] = playerSheet.crop(sheetWidth * 7 + 10, 0, 64, 64);
		//player_down[7] = playerSheet.crop(sheetWidth * 8, 0, 64, 64);
		
		player_right = new BufferedImage[7];
		
		player_right[0] = playerSheet.crop(sheetWidth * 2, sheetHeight, 64, 64);
		player_right[1] = playerSheet.crop(sheetWidth * 2, sheetHeight, 64, 64);
		player_right[2] = playerSheet.crop(sheetWidth * 3, sheetHeight, 64, 64);
		player_right[3] = playerSheet.crop(sheetWidth * 4, sheetHeight, 64, 64);
		player_right[4] = playerSheet.crop(sheetWidth * 5, sheetHeight, 64, 64);
		player_right[5] = playerSheet.crop(sheetWidth * 6, sheetHeight, 64, 64);
		player_right[6] = playerSheet.crop(sheetWidth * 7, sheetHeight, 64, 64);
		//player_right[7] = playerSheet.crop(sheetWidth * 8, sheetHeight, 64, 64);
		
		player_up = new BufferedImage[7];
		
		player_up[0] = playerSheet.crop(sheetWidth * 2, sheetHeight * 2, 64, 64);
		player_up[1] = playerSheet.crop(sheetWidth * 2, sheetHeight * 2, 64, 64);
		player_up[2] = playerSheet.crop(sheetWidth * 3, sheetHeight * 2, 64, 64);
		player_up[3] = playerSheet.crop(sheetWidth * 4, sheetHeight * 2, 64, 64);
		player_up[4] = playerSheet.crop(sheetWidth * 5, sheetHeight * 2, 64, 64);
		player_up[5] = playerSheet.crop(sheetWidth * 6, sheetHeight * 2, 64, 64);
		player_up[6] = playerSheet.crop(sheetWidth * 7, sheetHeight * 2, 64, 64);
		//player_up[7] = playerSheet.crop(sheetWidth * 8, sheetHeight * 2, 64, 64);
		
		player_left = new BufferedImage[7];
		
		player_left[0] = playerSheet.crop(sheetWidth * 2, sheetHeight * 3, 64, 64);
		player_left[1] = playerSheet.crop(sheetWidth * 2, sheetHeight * 3, 64, 64);
		player_left[2] = playerSheet.crop(sheetWidth * 3, sheetHeight * 3, 64, 64);
		player_left[3] = playerSheet.crop(sheetWidth * 4, sheetHeight * 3, 64, 64);
		player_left[4] = playerSheet.crop(sheetWidth * 5, sheetHeight * 3, 64, 64);
		player_left[5] = playerSheet.crop(sheetWidth * 6, sheetHeight * 3, 64, 64);
		player_left[6] = playerSheet.crop(sheetWidth * 7, sheetHeight * 3, 64, 64);
		//player_left[7] = playerSheet.crop(sheetWidth * 8, sheetHeight * 3, 64, 64);
		
		playerStill = playerSheet.crop(0, 0, 64, 64);
		
		player = sheet.crop(0, width, width, height);
		stone = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		
	}
	
}
