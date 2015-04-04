package tilegame.main.entities.creatures;

import java.awt.Graphics;

import tilegame.gfx.Assets;
import tilegame.main.Game;

public class Player extends Creature{

	private Game game;
	
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up)
			y -= 0.5;
		if(game.getKeyManager().down)
			y += 0.5;
		if(game.getKeyManager().left)
			x -= 0.5;
		if(game.getKeyManager().right)
			x += 0.5;
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
		
	}
	

}
