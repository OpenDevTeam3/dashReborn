package dash.util;

import dash.block.BlockJohnCena;
import dash.block.Platform;
import dash.block.Trap;
import dash.block.Wall;
import dash.block.Coin;
import dash.entities.Player;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;


public class MoveBlockerRulesApplierDash extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Gere la collision entre un joueur et un bloc de terrain.
	 * 
	 * @param player le joueur
	 * @param blocker le bloc de terrain
	 */
	public void moveBlockerRule(Player player, Platform blocker){
		
		//pas de collision si le joueur est mort
		if(player.isDead())
			return;
				
		player.getSpeedVector().getDirection().y=5;
		player.getPosition().y=(int) (blocker.getPosition().y-player.getBoundingBox().getHeight());
		player.setOntheground();
		
	}
	
	public void moveBlockerRule(Player player, Wall wall){
		player.kill();
	}
	
	public void moveBlockerRule(Player player, Trap trap){
		player.kill();
	}
	
	public void moveBlockerRule(Player movable, Coin piece){
		piece.addscore();
	}
	
	public void moveBlockerRule(Player player, BlockJohnCena andHisNameIs){
		andHisNameIs.johnCena();
	}
	
}
