package main.Dash;
import gameframework.game.GameData;
import gameframework.game.GameEntity;

import java.awt.Point;
import java.util.Iterator;

public class Camera {

	private Point position;
	private GameData data;
	private int speed;
	private GenerateurTerrain generateurTerrain;
	
	private static Camera instance = new Camera();
	
	public static void setData(GameData data) {
		instance.data = data;
		instance.speed = ((ConfigurationDash)data.getConfiguration()).getVitesse();
		instance.position = new Point(0,0);
		instance.generateurTerrain = new GenerateurTerrain(data);			
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public static Camera getInstance() {
		return instance;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void moveCamera() {
		
		Iterator<GameEntity> gt = data.getUniverse().getGameEntitiesIterator();
		while(gt.hasNext()){
			GameEntity tmp = gt.next();
			if(tmp instanceof BlockTerrain && ((BlockTerrain) tmp).getPosition().x+500<position.x){
				data.getUniverse().removeGameEntity(tmp);
			}else if(tmp instanceof Player){
				position.x+=((Player)tmp).getSpeedVector().getDirection().x*speed;
				position.y=((Player)tmp).getPosition().y-300;
			}
		}
		generateurTerrain.generate(position.x);
	}
	
	
}
