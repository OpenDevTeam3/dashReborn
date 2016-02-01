package dash;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class BlockTerrain implements Overlappable,GameEntity,MoveBlocker{
	
	private static SpriteManagerVariationTextureDash sprite;
	
	protected Point position;
	protected GameData data;
	protected String idBlock;
	protected int variation;
	
	public BlockTerrain(GameData data,String idBlock,int variation,int x,int j){
		if(sprite==null){
			sprite = new SpriteManagerVariationTextureDash(new DrawableImage("../../tileset.png", data.getCanvas()),64, 6, 4);
			sprite.setTypes("1","2","3","4");
		}
		this.idBlock=idBlock;
		this.variation=variation;
		this.data=data;
		this.position=new Point(x, j);
	}
	
	public void setPositionCamera(int x){
		position.x=position.x+x;
	}
	
	@Override
	public void draw(Graphics g) {
		sprite.setType(idBlock,variation);
		
	 	sprite.draw(g, new Point(position.x-Camera.getInstance().getX(),position.y-Camera.getInstance().getY()));
		
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position.x,position.y,64, 64);
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	public BlockTerrain duplique() {
		return new BlockTerrain( data, idBlock, variation, position.x, position.y);
	}
	
}
