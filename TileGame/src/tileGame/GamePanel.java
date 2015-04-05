package tileGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import javax.swing.JPanel;

import GameState.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener{

	//dimensions
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	
	//thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	//gamestate manager
	private GameStateManager gsm;
	
	public GamePanel(){
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init(){
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) g;
		running = true;
		
		gsm = new GameStateManager();
	}
	
	public void run(){
		init();
		long start;
		long elapsed;
		long wait;
		
		while(running){
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			
			try{
				Thread.sleep(wait);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void update(){
		gsm.update();
	}
	private void draw(){
		gsm.draw(g);;
	}
	private void drawToScreen(){
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key){
		
	}
	
	public void keyPressed(KeyEvent key){
		gsm.keyPressed(key.getKeyCode());
	}
	
	public void keyReleased(KeyEvent key){
		gsm.keyReleased(key.getKeyCode());
	}
	
}