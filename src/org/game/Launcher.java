package org.game;

import org.display.Display;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("title!!", 400, 400);
		game.start();
	}
	
}
