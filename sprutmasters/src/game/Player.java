package game;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		
	}

	public void tick() {
		
				
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 12, 12);
	}
	
	
	
	
	
	
}
