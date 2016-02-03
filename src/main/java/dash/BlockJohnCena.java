package dash;

import gameframework.game.GameData;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class BlockJohnCena extends BlockTerrain {


	public BlockJohnCena(GameData data, String idBlock, int variation,
			int x, int j) {
		super(data, idBlock, variation, x, j+12);
	}
	
	@Override
	public void draw(Graphics g){
		//you can't see me
		g.setColor(Color.RED);
		g.drawRect(position.x-Camera.getInstance().getX(),position.y-Camera.getInstance().getY(), 64, 50);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position.x,position.y, 64, 50);
	}
	
	public BlockTerrain duplique() {
		return new BlockJohnCena( data, idBlock, variation, position.x, position.y);
	}
}
