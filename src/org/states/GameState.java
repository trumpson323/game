package org.states;

import java.awt.Graphics;

import org.display.Handler;
import org.entities.creatures.Player;
import org.world.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
		
		
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
