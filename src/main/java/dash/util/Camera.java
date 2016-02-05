package dash.util;
import java.awt.Point;

import dash.entities.Player;

public class Camera {

	private Point position;
	
	public Camera() {
		this.position = new Point(0,0);
	}
	
	public void initPosition(Point p){
		this.position.setLocation(p);
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}

	/*public void moveCamera() {
		
		Iterator<GameEntity> gt = data.getUniverse().getGameEntitiesIterator();
		while(gt.hasNext()){
			GameEntity tmp = gt.next();
			if(tmp instanceof BlockTerrain && ((BlockTerrain) tmp).getPosition().x+500<position.x){
				data.getUniverse().removeGameEntity(tmp);
			}else if(tmp instanceof Player){
				setCameraOnPlayer((Player)tmp);	
			}
		}
		generateurTerrain.generate(position.x);
	}*/

	public void setCameraOnPlayer(Player player) {
		if(player.isDead()){
			return;
		}
		position.x=player.getPosition().x-200;
		position.y=player.getPosition().y/3;
	}
	
	
}
