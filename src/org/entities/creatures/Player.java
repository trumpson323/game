package org.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.display.Animations;
import org.display.Handler;
import org.images.Assets;

public class Player extends Creature{

	private Animations down, left, right, up;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		down = new Animations(100, Assets.player_down);
		up = new Animations(100, Assets.player_up);
		left = new Animations(100, Assets.player_left);
		right = new Animations(100, Assets.player_right);
	}

	@Override
	public void tick() {
		down.update();
		up.update();
		left.update();
		right.update();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
		
	}
		
	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x- handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffest()), width, height, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffest()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return left.getCurrentFrame();
		} else if(xMove > 0) {
			return right.getCurrentFrame();
		} else if (yMove < 0) {
			return up.getCurrentFrame();
		} else if(yMove > 0) {
			return down.getCurrentFrame();
		} else {
			return Assets.playerStill;
		}
	}
}
