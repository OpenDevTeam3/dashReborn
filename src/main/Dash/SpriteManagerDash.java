package main.Dash;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.SpriteManager;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class SpriteManagerDash implements SpriteManager{

	private final DrawableImage image;
	private Map<String, Integer> types;
	private final int spriteSize;
	private int spriteNumber = 0;
	private final int maxSpriteNumber;
	private int currentRow;
	private final int renderingSize;
	private boolean modeanimation;
	private int aftertype;
	private int decalage;
	
	public SpriteManagerDash(DrawableImage image, int renderingSize,int maxSpriteNumber,int decalage) {
		this(image, renderingSize,maxSpriteNumber);
		this.decalage=decalage;
	}


	public SpriteManagerDash(DrawableImage image, int renderingSize,
			int maxSpriteNumber) {
		this.renderingSize = renderingSize;
		this.image = image;
		this.maxSpriteNumber = maxSpriteNumber;
		this.spriteSize = image.getWidth() / maxSpriteNumber;
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
		int sx1 = spriteNumber * spriteSize + decalage*spriteNumber;
		int sy1 = currentRow * spriteSize + decalage*currentRow;
		int sx2 = sx1 + spriteSize;
		int sy2 = sy1 + spriteSize;
		
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
		int sy1 = currentRow * height;
		int sx2 = sx1 + width;
		int sy2 = sy1 + height;
		
		g.drawImage(image.getImage(), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
				null);
	}
	
	public void animation(String type,String aftertype){
		if (!types.containsKey(type) && !types.containsKey(aftertype)) {
			throw new IllegalArgumentException(type
					+ " is not a valid type for this sprite manager.");
		}
		this.aftertype = types.get(aftertype);
		this.currentRow = types.get(type);
		modeanimation=true;
	}

	@Override
	public void setType(String type) {
		if (!types.containsKey(type)) {
			throw new IllegalArgumentException(type
					+ " is not a valid type for this sprite manager.");
		}
		this.currentRow = types.get(type);
	}

	@Override
	public void increment() {
		spriteNumber = (spriteNumber + 1) % maxSpriteNumber;
		if(modeanimation && spriteNumber==0){
			modeanimation=false;
			currentRow=aftertype;
		}
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
