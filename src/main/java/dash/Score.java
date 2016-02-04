package dash;

import java.awt.Graphics;

import gameframework.game.GameEntity;

public class Score implements GameEntity{

	private int score;

	@Override
	public void draw(Graphics g) {
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