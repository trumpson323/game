package org.states;

import java.awt.Graphics;

import org.images.Assets;

public class GameState extends State{

	public GameState() {
		
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.grass, 0, 0, null);
	}

}
