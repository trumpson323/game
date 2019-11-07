package org.states;

import java.awt.Graphics;

import org.Tiles.Tile;
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
		Tile.tiles[0].render(g, 0, 0);
		player.render(g);
		
		
	}

}
