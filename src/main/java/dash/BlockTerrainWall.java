package dash;

import gameframework.game.GameData;

public class BlockTerrainWall extends BlockTerrain {

	public BlockTerrainWall(GameData data, String idBlock, int variation, int x, int y) {
		super(data, idBlock, variation, x, y);
	}
	
	public BlockTerrain duplique() {
		return new BlockTerrainWall( data, idBlock, variation, position.x, position.y);
	}

}
