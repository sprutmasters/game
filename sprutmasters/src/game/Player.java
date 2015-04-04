package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {

	Handler handler;
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,12,12);
	}

	
	private void collision(){
		for(int i = 0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Zombie){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 5;
				}
				
			}
		}
	}
	
	public void tick() {
		
		
		x += vX;
		y += vY;
		
		x = Game.clamp(x, 0, Game.WIDTH-18);
		y = Game.clamp(y, 0, Game.HEIGHT-40);
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 12, 12, 0.1f, handler));
		
		collision();
				
	}

	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect(x, y, 12, 12);
		
	}
	
	
}
