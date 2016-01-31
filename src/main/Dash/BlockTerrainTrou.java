package main.Dash;

import gameframework.game.GameData;

import java.awt.Rectangle;


public class BlockTerrainTrou extends BlockTerrain {


	public BlockTerrainTrou(GameData data, String idBlock, int variation,
			int x, int j) {
		super(data, idBlock, variation, x, j);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle();
	}
	
	public BlockTerrain duplique() {
		return new BlockTerrainTrou( data, idBlock, variation, position.x, position.y);
	}
}
