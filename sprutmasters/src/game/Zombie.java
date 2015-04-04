package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Zombie extends GameObject{

	private Random r;
	private Handler handler;
	
	
	public Zombie(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		r = new Random();
		
		vX = 5 + r.nextInt(10);
		vY = 5 + r.nextInt(10);
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,20,20);
	}


	public void tick() {
		x += vX;
		y += vY;
		
		if(y <= 0 || y >= Game.HEIGHT - 40){
			vY *= -1;
		}
		if(x <= 0 || x >= Game.WIDTH - 40){
			vX *= -1;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 20, 20, 0.08f, handler));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);
		
	}
	
	

}
