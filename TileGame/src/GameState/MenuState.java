package GameState;

import java.awt.*;
import TileMap.Background;

public class MenuState extends GameState {

	private Background bg;
	
	private String[] options = {
			"Start",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm){
		this.gsm = gsm;
		
		try{
			bg = new Background("", 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void init(){
		
	}
	public void update(){
		
	}
	public void draw(java.awt.Graphics2D g){
		
	}
	public void keyPressed(int k){
		
	}
	public void keyReleased(int k){
		
	}
	
}
