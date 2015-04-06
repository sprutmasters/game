package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState {

	private Background bg;
	
	private int currentChoice = 0;
	
	private String[] options = {
			"Start",
			"Help",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	private Color invisColor;
	
	private Font font;
	
	public MenuState(GameStateManager gsm){
		this.gsm = gsm;
		
		try{
			bg = new Background("/Menu/backgroundmenu.png", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 128, 0);
			invisColor = new Color(0,0,0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 80);
			
			font = new Font("Arial", Font.PLAIN, 30);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void init(){
		
	}
	public void update(){
		bg.update();
	}
	public void draw(java.awt.Graphics2D g){
		//background
		bg.draw(g);
		//title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("TileGame", 1920/2 - 225, 300);
		
		//draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.gray);
				g.drawString(">>",1920/2-120, 700+(i*40));
			}else{
				g.setColor(Color.black);
			}
			g.drawString(options[i], 1920/2 -80, 700 + (i*40));
			
			
		}
		
		
	}
		//MENU BUTTONS
	private void select(){
		//START
		if(currentChoice == 0){
			gsm.setState(GameStateManager.getWorldstate());
			
			
		}
		//HELP
		if(currentChoice == 1){
			
		}
		//EXIT
		if(currentChoice == 2){
			System.exit(0);
		}
	}
	
	public void keyPressed(int k){
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_W){
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = 0;
			}
		}
		if(k == KeyEvent.VK_S){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice = options.length -1;
			}
		}
	}
	public void keyReleased(int k){
		
	}
	
}
