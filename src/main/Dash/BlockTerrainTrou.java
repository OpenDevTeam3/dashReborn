package main.Dash;

import gameframework.game.GameData;

import java.awt.Point;
import java.awt.Rectangle;


public class BlockTerrainTrou extends BlockTerrain {

	public BlockTerrainTrou(GameData data, String type, Point p) {
		super(data, type, p);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle();
	}
}
