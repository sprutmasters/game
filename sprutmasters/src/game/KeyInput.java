package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public int yspeed = 1;
	public int xspeed = 1;
	
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//Key events for player 1
				
				
				if(key == KeyEvent.VK_W){
					if(yspeed>-1){
						yspeed = -1;
					}
					tempObject.setY(tempObject.getY() + yspeed);
					yspeed -= 1;
				}
				if(key == KeyEvent.VK_S){
					if(yspeed<1){
						yspeed = 1;
					}
					tempObject.setY(tempObject.getY() + yspeed);
					yspeed += 1;
				}
				if(key == KeyEvent.VK_A){
					if(xspeed>-1){
						xspeed = -1;
					}
					tempObject.setX(tempObject.getX() + xspeed);
					xspeed -=1;
				}
				if(key == KeyEvent.VK_D){
					if(xspeed<1){
						xspeed = 1;
					}
					tempObject.setX(tempObject.getX() + xspeed);
					xspeed += 1;
				}
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
	}
	
}
