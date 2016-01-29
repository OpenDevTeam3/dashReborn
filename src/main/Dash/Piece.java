package main.Dash;

import gameframework.game.GameData;

import java.awt.Point;


public class Piece extends BlockTerrain {

	private int score;
	
	public Piece(GameData data, String type, Point p,int score) {
		super(data, type, p);
		this.score=score;
	}

	public void addscore(){
		data.getScore().setValue(data.getScore().getValue()+score);
		data.getUniverse().removeGameEntity(this);
	}
}
