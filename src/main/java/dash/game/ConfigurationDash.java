package dash.game;

import java.awt.Point;

import dash.entities.Score;
import dash.util.Camera;
import dash.util.MoveBlockerRulesApplierDash;
import gameframework.game.GameConfiguration;
import gameframework.motion.blocking.MoveBlockerRulesApplier;


public class ConfigurationDash extends GameConfiguration{
	
	private Score score;
	
	private Camera camera;
	
	public ConfigurationDash(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
		score = new Score();
		camera = new Camera();
	}

	public MoveBlockerRulesApplier createMoveBlockerRulesApplier() {
		return new MoveBlockerRulesApplierDash();
	}
	
	public int getVitesse(){
		return 1;
	}
	
	public int getBlockSize(){
		return 64;
	}
	
	public Score getScore(){
		return score;
	}

	public Camera getCamera() {
		return camera;
	}

	public Point getPlayerSpawnLocation() {
		return new Point(100,380);
	}

	public int getCoinScore() {
		return 10;
	}

	public long getAccelerationTime() {
		return 3000;
	}

	public double getAccelerationSpeed() {
		return 0.5;
	}

}
