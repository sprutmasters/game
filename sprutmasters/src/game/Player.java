package game;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	public void tick() {
		
		
		x += vX;
		y += vY;
		
		x = Game.clamp(x, 0, Game.WIDTH-18);
		y = Game.clamp(y, 0, Game.HEIGHT-40);
		
				
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 12, 12);
		
	}
	
	
}
