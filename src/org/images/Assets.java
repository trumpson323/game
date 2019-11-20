package org.images;

import java.awt.image.BufferedImage;

import org.display.SpriteSheet;

public class Assets {

	private static final int width = 100, height = 100;
	
	public static BufferedImage player, stone, grass;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SSpritesheet (1).png"));
		
		player = sheet.crop(0, width, width, height);
		stone = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		
	}
	
}
