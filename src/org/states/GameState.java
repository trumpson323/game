package org.states;

import java.awt.Graphics;

import org.entities.creatures.Player;
import org.game.Game;

public class GameState extends State{
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		
	}
	
	public void tick() {
		
		player.tick();
		
	}

	public void render(Graphics g) {
	
		player.render(g);
		
	}

}
