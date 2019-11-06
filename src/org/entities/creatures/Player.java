package org.entities.creatures;

import java.awt.Graphics;

import org.game.Game;
import org.images.Assets;

public class Player extends Creature{

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.grass, (int) x, (int) y, width, height, null);
	}
	

}
