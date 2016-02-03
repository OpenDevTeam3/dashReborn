package dash;

import gameframework.game.GameData;


public class Piece extends BlockTerrain {

	public final static int DEFAULT_PIECE_SCORE = 10;
	
	public Piece(GameData data, String idBlock, int variation, int x, int j) {
		super(data, idBlock, variation, x, j);
	}

	public void addscore(){
		data.getScore().setValue(data.getScore().getValue()+DEFAULT_PIECE_SCORE);
		data.getUniverse().removeGameEntity(this);
	}
	
	public BlockTerrain duplique() {
		return new Piece( data, idBlock, variation, position.x, position.y);
	}
}
