package main.Dash;

import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;


public class MoveBlockerRulesApplierDash extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Gere la collision entre un joueur et un bloc de terrain.
	 * 
	 * @param player le joueur
	 * @param blocker le bloc de terrain
	 */
	public void moveBlockerRule(Player player, BlockTerrain blocker){
		player.getSpeedVector().getDirection().y=0;
		player.getPosition().y=(int) (blocker.getPosition().y-player.getBoundingBox().getHeight());
		
		//permet au joueur de sauter à nouveau
		player.setOntheground();
	}
	
	public void moveBlockerRule(Player player, BlockTerrainDie blocker){
		System.exit(0);
	}
	
	public void moveBlockerRule(Player movable, Piece blocker){
		blocker.addscore();
	}
	
	
}
