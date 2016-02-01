package dash;

import gameframework.game.GameConfiguration;
import gameframework.motion.blocking.MoveBlockerRulesApplier;


public class ConfigurationDash extends GameConfiguration{
	
	public ConfigurationDash(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
	}

	public MoveBlockerRulesApplier createMoveBlockerRulesApplier() {
		return new MoveBlockerRulesApplierDash();
	}
	
	public int getVitesse(){
		return 1;
	}

}
