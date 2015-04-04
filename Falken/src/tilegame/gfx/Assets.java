package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player, dirt, stone;
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles1.png"));
		
		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(0, height, width, height);
		stone = sheet.crop(width * 2, 0, width, height);
		
	}
	
	
}
