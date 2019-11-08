package org.states;

import java.awt.Graphics;

import org.entities.creatures.Player;
import org.game.Game;
import org.world.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		world = new World(game, "res/worlds/world1.txt");
		
	}
	
	public void tick() {
		world.update();
		player.tick();
	}

	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
