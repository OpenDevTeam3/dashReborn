package dash;

import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;


public class MoveBlockerRulesApplierDash extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Gere la collision entre un joueur et un bloc de terrain.
	 * 
	 * @param player le joueur
	 * @param blocker le bloc de terrain
	 */
	public void moveBlockerRule(Player player, BlockTerrain blocker){
		
		if(player.isDead())
			return;
		
		player.getSpeedVector().getDirection().y=5;
		player.getPosition().y=(int) (blocker.getPosition().y-player.getBoundingBox().getHeight());
		//permet au joueur de sauter à nouveau
		player.setOntheground();
		
	}
	
	public void moveBlockerRule(Player player, BlockTerrainWall wall){
		player.kill();
	}
	
	public void moveBlockerRule(Player player, BlockTerrainDie trap){
		System.exit(0);
	}
	
	public void moveBlockerRule(Player movable, Piece piece){
		piece.addscore();
	}
	
	public void moveBlockerRule(Player player, BlockJohnCena trou){
		player.kill();
	}
	
	
}
