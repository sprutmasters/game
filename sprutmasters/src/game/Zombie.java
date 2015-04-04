package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Zombie extends GameObject{

	private Random r;
	
	
	public Zombie(int x, int y, ID id) {
		super(x, y, id);
		
		r = new Random();
		
		vX = r.nextInt(10) + 5;
		vY = r.nextInt(10) + 5;
		
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
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);
		
	}
	
	

}
