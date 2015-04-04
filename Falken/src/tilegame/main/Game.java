package tilegame.main;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import tilegame.display.Display;
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
		private BufferedImage test;
		private SpriteSheet sheet;
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init(){
		display = new Display(title, width, height);
		test = ImageLoader.loadImage("/textures/tiles1.png");
		sheet = new SpriteSheet(test);
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
		g.drawImage(sheet.crop(32, 0, 32, 32), 0, 0, null);
	
	
		
		
		//END DRAWING
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
		
		init();
		
		while(running){
			tick();
			render();
			
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
	

