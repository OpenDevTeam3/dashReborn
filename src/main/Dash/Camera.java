package main.Dash;

import gameframework.game.GameData;
import gameframework.game.GameEntity;

import java.awt.Point;
import java.util.Iterator;
import java.util.Random;

public class Camera {

	private Point position;
	private GameData data;
	private int speed;
	private static Camera instance=new Camera();
	
	public static void setData(GameData data) {
		instance.data = data;
		instance.speed = ((ConfigurationDash)data.getConfiguration()).getVitesse();
		instance.position = new Point(0,0);
				
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
		position.x+=speed;
		
		Iterator<GameEntity> gt = data.getUniverse().getGameEntitiesIterator();
		int nbblock=0;
		boolean bool=true;
		for (; gt.hasNext();) {
			nbblock++;
			GameEntity tmp = gt.next();
			if(tmp instanceof BlockTerrain && ((BlockTerrain) tmp).getPosition().x+200<position.x){
				data.getUniverse().removeGameEntity(tmp);
				if(bool){
					generateTerrain();
				}
				bool=false;
			}
		}
		System.out.println("nbblock : "+nbblock);
	}
	
	public void generateTerrain(){
		BlockTerrain  block;
		
			block = new BlockTerrain(data, "herbe", new Point(position.x+data.getCanvas().getWidth(),550));
			data.getUniverse().addGameEntity(block);
		if(new Random().nextInt(12)==0){
			block = new BlockTerrainDie(data, "pic", new Point(position.x+data.getCanvas().getWidth(),500));
			data.getUniverse().addGameEntity(block);
		}
		
		if(new Random().nextInt(5)==0){
			block = new Piece(data, "terre", new Point(position.x+data.getCanvas().getWidth(),350),100);
			data.getUniverse().addGameEntity(block);
		}
	}
}
