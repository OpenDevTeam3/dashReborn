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
		
		player.getSpeedVector().getDirection().y=10;
		player.getPosition().y=(int) (blocker.getPosition().y-player.getBoundingBox().getHeight()-player.getSpeedVector().getDirection().y);
		//permet au joueur de sauter à nouveau
		player.setOntheground();
		
	}
	
	public void moveBlockerRule(Player player, BlockTerrainDie trap){
		System.exit(0);
	}
	
	public void moveBlockerRule(Player movable, Piece piece){
		piece.addscore();
	}
	
	public void moveBlockerRule(Player player, BlockJohnCena trou){
		System.out.println("ok");
		player.kill();
		player.getPosition().x = trou.getPosition().x;
		player.getSpeedVector().getDirection().x = 0;
		System.out.println(player.getPosition().x);
	}
	
	
}
