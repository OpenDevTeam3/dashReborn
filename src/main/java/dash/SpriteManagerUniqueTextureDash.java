package dash;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;


public class SpriteManagerUniqueTextureDash implements SpriteManager{

	private final DrawableImage image;
	private Map<String, Integer> types;
	private final int maxSpriteNumber;
	private int spriteNumber;
	private final int renderingSize;
	private int spriteWight;
	private int spriteHeight;
	private int nbSpriteLine;
	private int nbSpriteCol;
	
	public SpriteManagerUniqueTextureDash(DrawableImage image, int renderingSize,int nbSpriteCol,int nbSpriteLine) {
		this.renderingSize = renderingSize;
		this.image = image;
		this.maxSpriteNumber = nbSpriteCol*nbSpriteLine;
		this.nbSpriteCol=nbSpriteCol;
		this.nbSpriteLine=nbSpriteLine;
		this.spriteWight= image.getWidth() / nbSpriteCol;
		this.spriteHeight = image.getHeight() / nbSpriteLine;
	}
	
	@Override
	public void setTypes(String... types) {
		int i = 0;
		this.types = new HashMap<String, Integer>(types.length);
		for (String type : types) {
			this.types.put(type, i);
			i++;
		}
	}

	@Override
	public void draw(Graphics g, Point position) {
		// Destination image coordinates
		int dx1 = (int) position.getX();
		int dy1 = (int) position.getY();
		int dx2 = dx1 + renderingSize;
		int dy2 = dy1 + renderingSize;

		// Source image coordinates
		int sx1 = (spriteNumber%nbSpriteCol) * spriteWight;
		int sy1 = (spriteNumber/nbSpriteCol) * spriteHeight;
		int sx2 = sx1 + spriteWight;
		int sy2 = sy1 + spriteHeight;
		
		g.drawImage(image.getImage(), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
				null);
	}
	
	public void draw(Graphics g, Point position,int width,int height) {
		// Destination image coordinates
		int dx1 = (int) position.getX();
		int dy1 = (int) position.getY();
		int dx2 = dx1 + renderingSize;
		int dy2 = dy1 + renderingSize;

		// Source image coordinates
		int sx1 = spriteNumber * width;
		int sy1 = spriteNumber * height;
		int sx2 = sx1 + width;
		int sy2 = sy1 + height;
		
		g.drawImage(image.getImage(), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
				null);
	}

	@Override
	public void setType(String type) {
		if (!types.containsKey(type)) {
			throw new IllegalArgumentException(type
					+ " is not a valid type for this sprite manager.");
		}
		this.spriteNumber = types.get(type);
	}

	@Override
	public void increment() {
		spriteNumber++;
	}

	@Override
	public void reset() {
		spriteNumber = 0;
	}

	@Override
	public void setIncrement(int increment) {
		this.spriteNumber = increment;
	}

	

}
