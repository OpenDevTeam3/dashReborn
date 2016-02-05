package dash.block;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import dash.game.ConfigurationDash;
import dash.sprite.SpriteManagerVariationTextureDash;
import dash.util.Camera;


/**
 * La classe Platform permet d'instancier des blocs de terrain carrés sur lequel le joueur peut marcher.
 * 
 * @author lucasmouradeoliveira
 *
 */
public class Platform implements Overlappable,GameEntity,MoveBlocker{
	
	private static SpriteManagerVariationTextureDash sprite;
	
	protected Point position;
	
	protected GameData data;
	
	protected ConfigurationDash config;
	
	protected Camera camera;
	
	protected String idBlock;
	
	protected int variation;
	
	/**
	 * Crée une nouvelle plateforme.
	 * 
	 * @param data les données de jeu
	 * @param idBlock l'identifiant de l'image du bloc
	 * @param variation l'identifiant de variation pour l'image du bloc
	 * @param x la position en abscisse du bloc
	 * @param y la position en ordonnée du bloc
	 * 
	 */
	public Platform(GameData data,String idBlock,int variation,int x, int y){
		this.idBlock=idBlock;
		this.variation=variation;
		this.data=data;
		this.config = ((ConfigurationDash) data.getConfiguration());
		this.camera = config.getCamera();
		this.position = new Point(x, y);
		if(sprite==null){
			sprite = new SpriteManagerVariationTextureDash(new DrawableImage("../../tileset.png", data.getCanvas()), config.getBlockSize(), 6, 5);
			sprite.setTypes("1","2","3","4","5");
		}
	}
	/**
	 * Définit la position x du bloc.
	 * 
	 * @param x le décalage en x à ajouter au bloc
	 */
	public void offset(int x){
		position.x=position.x+x;
	}
	
	@Override
	public void draw(Graphics g) {
		sprite.setType(idBlock,variation);	
	 	sprite.draw(g, new Point(position.x-camera.getX(),position.y-camera.getY()));	
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position.x,position.y, config.getBlockSize(), config.getBlockSize());
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	/**
	 * Retourne une copie du bloc.
	 */
	public Platform duplique() {
		return new Platform( data, idBlock, variation, position.x, position.y);
	}
	
}
