package tilegame.main;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import tilegame.display.Display;
import tilegame.gfx.Assets;
import tilegame.gfx.ImageLoader;
import tilegame.gfx.SpriteSheet;

	public class Game implements Runnable{

		public int width, height;
		public String title;
	
		private boolean running = false;
		private Display display;
		private Thread thread;
		private BufferStrategy bs;
		private Graphics g;

	
	
	
	public Game(String title, int width, int height){		
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init(){		
		display = new Display(title, width, height);
		Assets.init();
		
		
	}
	
	private void tick(){
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//CLEAR SCREEN
		g.clearRect(0, 0, width, height);
		//DRAW HERE (Tile x, Tile y, 32, 32), x, y
		
		g.drawImage(Assets.dirt, 10, 10, null);
	
	
		
		
		//END DRAWING
		bs.show();
		g.dispose();
		
	}
	
	public void run(){		
		init();
		
		int fps = 144;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running){
			now = System.nanoTime();
			delta+= (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				delta --;
			}
			
			
		}
		
		stop();
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
	

