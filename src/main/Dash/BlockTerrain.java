package main.Dash;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class BlockTerrain implements Overlappable,GameEntity,MoveBlocker{
	
	private static SpriteManagerUniqueTextureDash sprite;
	private String type;
	
	private Point position;
	protected GameData data;
	
	public BlockTerrain(GameData data,String type,Point p){
		if(sprite==null){
			sprite = new SpriteManagerUniqueTextureDash(new DrawableImage("../../platforme.png", data.getCanvas()),50, 4,4);
			sprite.setTypes("herbe","terre","roche","pic");
		}
		this.type=type;
		this.position = p;
		this.data=data;
	}
	
	@Override
	public void draw(Graphics g) {
		sprite.setType(type);
		
	 	sprite.draw(g, new Point(position.x-Camera.getInstance().getX(),position.y-Camera.getInstance().getY()));
		
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position.x,position.y,150, 150);
	}

	public SpriteManagerUniqueTextureDash getSpriteBlockTerrainManager(){
		return sprite;
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public Point getPosition() {
		return position;
	}
	
}
