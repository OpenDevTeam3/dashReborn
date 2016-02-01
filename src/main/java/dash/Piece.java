package dash;

import gameframework.game.GameData;


public class Piece extends BlockTerrain {

	private int score;
	
	public Piece(GameData data, String idBlock, int variation, int x, int j) {
		super(data, idBlock, variation, x, j);
		this.score=variation;
	}

	public void addscore(){
		data.getScore().setValue(data.getScore().getValue()+score);
		data.getUniverse().removeGameEntity(this);
	}
	
	public BlockTerrain duplique() {
		return new Piece( data, idBlock, variation, position.x, position.y);
	}
}
