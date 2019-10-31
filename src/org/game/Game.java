package org.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import org.display.Display;
import org.display.SpriteSheet;
import org.images.ImageLoader;


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
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/textures/trump_run.png");
		sheet = new SpriteSheet(testImage);
	}
	
	
	private void update() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		g.drawImage(sheet.crop(0, 0, 100, 100) ,20, 20, null);
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		while(running) {
			update();
			render();
		}
		stop();
		
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
