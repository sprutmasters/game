package GameState;

import java.awt.Graphics2D;

import TileMap.Tile;
import TileMap.TileMap;

public class Worldstate extends GameState {
	
	private TileMap tilemap;
	
	public Worldstate(GameStateManager gsm){
		this.gsm = gsm;
		
		
	}
	
	public void init() {
		
		tilemap = new TileMap(30);
	
	}

	public void update() {
	
		
	}

	public void draw(Graphics2D g) {
	
		
	}

	public void keyPressed(int k) {

		
	}

	public void keyReleased(int k) {

		
	}

}
