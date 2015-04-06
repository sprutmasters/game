package GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import tileGame.GamePanel;
import TileMap.Tile;
import TileMap.TileMap;

public class Worldstate extends GameState {
	
	private TileMap tilemap;
	
	public Worldstate(GameStateManager gsm){
		this.gsm = gsm;
		init();
		
		
	}
	
	public void init() {
		
		tilemap = new TileMap(30);
		tilemap.loadTiles("/res/textures/testtileset.gif");
		tilemap.loadMap("res/Maps/testlevel.map");
		tilemap.setPosition(0, 0);
	
	}

	public void update() {
	
		
	}

	public void draw(Graphics2D g) {
		
		//Clear Screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		//Draw Tiles
		tilemap.draw(g);
	
		
	}

	public void keyPressed(int k) {

		
	}

	public void keyReleased(int k) {

		
	}

}
