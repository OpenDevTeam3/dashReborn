package dash.game;

import gameframework.game.Game;
import gameframework.game.GameData;

import java.util.Observable;
import java.util.Observer;

public class DashGame implements Game, Observer{
	
	private GameData data;
	
	private GameLevelDash currentPlayedLevel;

	public DashGame(GameData data) {
		this.data = data;
		this.data.getScore().addObserver(this);
		this.data.getEndOfGame().addObserver(this);		
	}
	
	@Override
	public void start(){
		this.currentPlayedLevel = new GameLevelDash(data,25);
		this.currentPlayedLevel.start();
		try {
			currentPlayedLevel.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override 
	public void update(Observable o, Object arg){
		if(data.getEndOfGame().getValue()){
			this.currentPlayedLevel.restart();
		}
	}

}
