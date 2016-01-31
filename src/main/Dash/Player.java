package main.Dash;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;


public class Player extends GameMovable implements GameEntity,Drawable,MoveBlocker{

	private SpriteManagerDash sprite;
	
	private int anime=0;
	
	private boolean animenormal=false;
	
	private boolean ontheground;
	
	public boolean slow;
	
	private DrawableImage image;
	
	private Point2D.Double acceleration;
	
	public Player(GameCanvas gameCanvas,GameData data) {
		super();
		ontheground=false;
		
		slow = false;
		
		MoveStrategyPlayer moveStrategy=new MoveStrategyPlayer(this,data);
		moveDriver.setStrategy(moveStrategy);
		
		gameCanvas.addKeyListener(moveStrategy);
		
		
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		
		
		//this.gameCanvas=gameCanvas;
		image = new DrawableImage("../../spriteBOB.png", gameCanvas);
		
		this.sprite = new SpriteManagerDash(image, 128, 8);
		this.sprite.setTypes("course","saut");
		this.sprite.setType("course");
		this.acceleration = new Point2D.Double(0, 0);
		
		setPosition(new Point(100, 400));
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(getPosition().x+32,getPosition().y, 64, 128);
	}
	
	
	@Override
	public void draw(Graphics g) {
		
		sprite.draw(g, new Point(getPosition().x-Camera.getInstance().getX(),getPosition().y-Camera.getInstance().getY()),40,40);
		
		// hit box
		//g.drawRect(getPosition().x-Camera.getInstance().getX()+32,getPosition().y-Camera.getInstance().getY(),64, 128);
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		setSprite();
		applyGravity();
	}
	
	private void setSprite() {
		if(animenormal && (anime++)==9){
			this.sprite.setType("course");
			this.sprite.reset();
		}
		this.sprite.increment();	
	}

	private void applyGravity() {		
		this.acceleration.y+=0.2;
		this.getSpeedVector().getDirection().y+=this.acceleration.y;
	}

	public int jump() {
		ontheground = false;
		sprite.setType("saut");
		sprite.reset();
		animenormal=true;
		anime=0;
		return getSpeedVector().getDirection().y=-30;
	}
	
	public boolean isOntheGround(){
		return ontheground;
	}

	public void setOntheground() {
		this.ontheground=true;
		this.acceleration.y=0;
	}
	
}
