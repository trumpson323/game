package org.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import org.display.Display;
import org.display.GameCamera;
import org.display.Handler;
import org.display.SpriteSheet;
import org.images.Assets;
import org.input.KeyManager;
import org.states.GameState;
import org.states.MenuState;
import org.states.State;


public class Game implements Runnable{

	private Display display;
	private int width, height;
	public String title;
	
	private Thread thread;
	private Boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	private SpriteSheet sheet;
	
	private State gameState;
	private State menuState;
	
	private KeyManager keyManager;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}
	private GameCamera gameCamera;
	
	private Handler handler;
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}
	
	
	private void update() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if(running) 
			return;

		running = true;
		thread = new Thread(this);
		thread.start();

	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
