package dash.entities;

import gameframework.game.GameEntity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score implements GameEntity{

	public static final Font SCORE_FONT = new Font("Comics Sans", Font.BOLD, 48);
	
	private int score;
	
	@Override
	public void draw(Graphics g) {
		g.setFont(SCORE_FONT);
		g.setColor(Color.RED);
		g.drawString("Score : "+score, 50, 50);
	}
	
	@Override
	public boolean isMovable() {
		return false;
	}
	
	public void addScore(int score){
		this.score+=score;
	}

	public void reset(){
		score = 0;
	}

}