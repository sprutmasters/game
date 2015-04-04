package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	
	
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
					tempObject.setvY(-5);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setvY(5);
				}
				if(key == KeyEvent.VK_A){
					tempObject.setvX(-5);
				}
				if(key == KeyEvent.VK_D){
					tempObject.setvX(5);
				}
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//Key events for player 1
				
				
				if(key == KeyEvent.VK_W){
					tempObject.setvY(0);
				}
				if(key == KeyEvent.VK_S){
					tempObject.setvY(0);
				}
				if(key == KeyEvent.VK_A){
					tempObject.setvX(0);
				}
				if(key == KeyEvent.VK_D){
					tempObject.setvX(0);
				}
			}
		}
	}
	
}
