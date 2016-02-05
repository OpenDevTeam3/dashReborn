package dash.entities;

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

import dash.game.ConfigurationDash;
import dash.sprite.SpriteManagerDash;
import dash.util.Camera;
import dash.util.MoveStrategyPlayer;

/**
 * La class Player permet d'instancier un personnage de jeu.
 * 
 * @author lucasmouradeoliveira
 *
 */
public class Player extends GameMovable implements GameEntity,Drawable,MoveBlocker{

	private SpriteManagerDash sprite;
	
	private int anime=0;
	
	private boolean animenormal;
	
	private boolean ontheground, slow;
	
	private DrawableImage image;
	
	private int animationTick;
	
	private boolean dead;
	
	private Point2D.Double acceleration;
	
	private GameData data;
	
	private ConfigurationDash config;
	
	private Camera camera;
	
	private MoveStrategyPlayer moveStrategy;
	
	public Player(GameCanvas gameCanvas,GameData data) {
		super();
		this.data = data;
		this.config = ((ConfigurationDash) data.getConfiguration());
		this.camera = config.getCamera();
		
		this.initState();
		this.image = new DrawableImage("../../spriteBOB.png", gameCanvas);
		this.initSprite();
		this.initMoveStrategy();
		
	}
	
	/**
	 * Initialise l'état des animations du joueur.
	 */
	public void initState(){
		this.animenormal = false;
		this.ontheground = false;
		this.slow = false;
		this.dead = false;
		this.acceleration = new Point2D.Double(0, 0);
		this.animationTick = 0;
	}
	
	private void initSprite(){	
		this.sprite = new SpriteManagerDash(image, 128, 8);
		this.sprite.setTypes("course","saut");
		this.sprite.setType("course");
	}
	
	private void initMoveStrategy(){
		this.moveStrategy=new MoveStrategyPlayer(this,data);
		this.moveDriver.setStrategy(moveStrategy);
		this.data.getCanvas().addKeyListener(moveStrategy);
		this.moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(getPosition().x,getPosition().y, 64, 128);
	}
	
	
	@Override
	public void draw(Graphics g) {
		sprite.draw(g, new Point(getPosition().x-camera.getX()-32,getPosition().y-camera.getY()),40,40);
	}
	
	@Override
	public void oneStepMove(){
		ontheground = false;
		super.oneStepMove();
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		setSprite();
		applyGravity();
		checkBoundaries();
	}
	
	/**
	 * Vérifie si le joueur est tombé dans le vide. Si c'est le cas, il est tué.
	 */
	private void checkBoundaries() {
		if(position.y > 800){
			kill();
		}
	}

	private void setSprite() {
		if(animenormal && (anime++)==9){
			this.sprite.setType("course");
			this.sprite.reset();
		}
		if(animationTick%2==0){
			this.sprite.increment();	
		}
		animationTick++;
	}

	private void applyGravity() {	
		if(slow){
			this.acceleration.y+=0.1;
		}else{			
			this.acceleration.y+=0.5;
		}
		this.getSpeedVector().getDirection().y+=Math.ceil(this.acceleration.y);		
		this.getSpeedVector().getDirection().y=Math.min(this.getSpeedVector().getDirection().y,40);
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
	
	/**
	 * Tue le joueur et lui fait faire une petite animation de bond en arrière.
	 */
	public void kill(){
		if(dead)
			return;
		dead = true;
		getSpeedVector().getDirection().x = -10;
		getSpeedVector().getDirection().y = -20;
		sprite.setType("saut");
		data.getEndOfGame().setValue(true);
		
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public boolean isSlow(){
		return slow;
	}

	public void setSlow(boolean slow) {
		this.slow = slow;
	}
	
	public void accelerate(){
		this.acceleration.x+=config.getAccelerationSpeed();
		if(this.acceleration.x > 1){
			this.acceleration.x = 0;
			int x = Math.min(12, moveStrategy.getSpeedVector().getDirection().x+1);
			moveStrategy.setDirectionX(x);
		}
	}
	
}