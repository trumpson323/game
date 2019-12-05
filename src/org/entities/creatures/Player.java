package org.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.display.Animations;
import org.display.Handler;
import org.images.Assets;

public class Player extends Creature{

	private Animations down, left, right, up;
	private int direction = 1;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 80, 80);
		
		bounds.x = 26;
		bounds.y = 43;
		bounds.width = 24;
		bounds.height = 32;
		
		down = new Animations(135, Assets.player_down);
		up = new Animations(135, Assets.player_up);
		left = new Animations(135, Assets.player_left);
		right = new Animations(135, Assets.player_right);
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
				direction = 2;
				return left.getCurrentFrame();
			} else if(xMove > 0) {
				direction = 3;
				return right.getCurrentFrame();
			} else if (yMove < 0) {
				direction = 0;
				return up.getCurrentFrame();
			} else if(yMove > 0) {
				direction = 1;
				return down.getCurrentFrame();
			} 
		else {
				return Assets.playerStill[direction];
		}
		
	}
}
