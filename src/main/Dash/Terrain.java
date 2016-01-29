package main.Dash;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyKeyboard8Dir;
import gameframework.motion.blocking.MoveBlocker;


public class Terrain extends GameMovable implements GameEntity,Drawable,MoveBlocker{
	
	private SpriteManagerDash sprite;
	
	private ArrayList<BlockTerrain> blockTerrains;
	
	public Terrain(GameCanvas gameCanvas,GameData data){
		super();
		
		//MoveStrategyKeyboard8Dir moveStrategy=new MoveStrategyKeyboard8Dir();
		//moveDriver.setStrategy(moveStrategy);
		
		//gameCanvas.addKeyListener(moveStrategy);
		
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		
		DrawableImage image = new DrawableImage("../../playersprite.png", gameCanvas);
		this.sprite = new SpriteManagerDash(image, 200, 8);
		this.sprite.setTypes("normal","1","2","course");
		this.sprite.setType("course");
		
		setPosition(new Point(0, 580));
		
		
	
	}
	
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(getPosition().x,getPosition().y,1500, 150);
	}
	
	@Override
	public void draw(Graphics g) {
		// hit box
		g.drawRect(getPosition().x,getPosition().y, 1500,150);
	//	sprite.draw(g, getPosition(),46,50);
		
	}
	
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
	}

}
