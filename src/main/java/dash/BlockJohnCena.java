package dash;

import gameframework.game.GameData;

import java.awt.Graphics;
import java.awt.Rectangle;


public class BlockJohnCena extends BlockTerrain {


	public BlockJohnCena(GameData data, String idBlock, int variation,
			int x, int j) {
		super(data, idBlock, variation, x, j);
	}
	
	@Override
	public void draw(Graphics g){
		//you can't see me
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position.x,position.y+11, 64, 53);
	}
	
	public BlockTerrain duplique() {
		return new BlockJohnCena( data, idBlock, variation, position.x, position.y);
	}
}
