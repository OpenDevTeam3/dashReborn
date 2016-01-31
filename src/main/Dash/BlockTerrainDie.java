package main.Dash;

import gameframework.game.GameData;


public class BlockTerrainDie extends BlockTerrain {

	public BlockTerrainDie(GameData data, String idBlock, int variation, int x,
			int j) {
		super(data, idBlock, variation, x, j);
	}

	public BlockTerrain duplique() {
		return new BlockTerrainDie( data, idBlock, variation, position.x, position.y);
	}
}
