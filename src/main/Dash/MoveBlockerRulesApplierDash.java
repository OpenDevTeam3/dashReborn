package main.Dash;

import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;


public class MoveBlockerRulesApplierDash extends MoveBlockerRulesApplierDefaultImpl {
	
	public void moveBlockerRule(Player movable, BlockTerrain blocker){
		movable.getSpeedVector().getDirection().y=0;
		movable.getPosition().y=(int) (blocker.getPosition().y-movable.getBoundingBox().getHeight());
		movable.setOntheground(true);
	}
	
	public void moveBlockerRule(Player movable, BlockTerrainDie blocker){
		movable.getSpeedVector().getDirection().y=0;
		movable.getPosition().y=(int) (blocker.getPosition().y-movable.getBoundingBox().getHeight());
		movable.setOntheground(true);
		System.out.println("die");
	}
	
	public void moveBlockerRule(Player movable, Piece blocker){
		blocker.addscore();
	}
	
	public void moveBlockerRule(BlockTerrain movable, Player blocker){
		System.out.println("dead");
	}
	
	public void moveBlockerRule(BlockTerrain movable, BlockTerrain blocker){
		
	}
	
}
