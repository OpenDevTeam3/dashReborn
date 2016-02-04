package dash;

import gameframework.game.GameConfiguration;
import gameframework.motion.blocking.MoveBlockerRulesApplier;


public class ConfigurationDash extends GameConfiguration{
	
	private Score score;
	
	public ConfigurationDash(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
		score = new Score();
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

}
