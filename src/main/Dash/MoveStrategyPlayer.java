package main.Dash;

import java.awt.Point;
import java.awt.event.KeyEvent;

import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.SpeedVector;


public class MoveStrategyPlayer extends MoveStrategyKeyboard {
	
	private Player player;

	public MoveStrategyPlayer(Player player,GameData data) {
		super(new SpeedVector(new Point(1, 1)));
		int vitesse =((ConfigurationDash)data.getConfiguration()).getVitesse();
		setSpeed(vitesse);
		this.player=player;
	}

	@Override
	public void keyPressed(int keyCode) {
		
		int x = speedVector.getDirection().x;
		int y = speedVector.getDirection().y;
		int oldX=x;
		int oldY=y;
		switch (keyCode) {
			case KeyEvent.VK_SPACE:
				if(player.isOntheground())
					y=player.jump();
				break;
			default:
				return;
		}
		if(x!=oldX || y!=oldY)
			move(new Point(x, y));
	}

	/**
	 * Move according to the point parameter
	 * 
	 * @param point
	 *            the new direction of the movement
	 */
	private void move(Point point) {
		speedVector.setDirection(point);
	}

	/**
	 * Processes the direction according to the key released
	 * 
	 * @param keyCode
	 *            the code of the key released
	 */
	@Override
	public void keyReleased(int keyCode) {
		/*int x = speedVector.getDirection().x;
		int y = speedVector.getDirection().y;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			x=0;
			break;
		case KeyEvent.VK_LEFT:
			x=0;
			break;
		default:
			return;
		}
		move(new Point(x, y));*/
	}

}
