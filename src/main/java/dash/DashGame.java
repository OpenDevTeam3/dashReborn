package dash;

import gameframework.game.Game;
import gameframework.game.GameData;
import gameframework.game.GameLevel;

import java.util.Observable;
import java.util.Observer;

public class DashGame implements Game, Observer{
	
	private GameLevelDash currentPlayedLevel;

	protected final GameData data;
	
	protected Player player;

	public DashGame(GameData data) {
		this.data = data;
		this.data.getScore().addObserver(this);
		this.data.getEndOfGame().addObserver(this);
			
	}
	
	private void initPlayer() {
		this.player = new Player(data.getCanvas(), data);
	}
	
	private void initLevel() {
		Score score = ((ConfigurationDash)this.data.getConfiguration()).getScore();
		score.reset();
		this.currentPlayedLevel = new GameLevelDash(data,25);
		this.data.addLevel(currentPlayedLevel);
		this.data.getUniverse().addGameEntity(score);
	}
	
	private void clear() {
		for (GameLevel level : data.getLevels()){
			data.getEndOfGame().setValue(false);
			if (currentPlayedLevel != null && currentPlayedLevel.isAlive()) {
				currentPlayedLevel.interrupt();
				currentPlayedLevel = null;
			}
		}
		data.getUniverse().removeAllGameEntities();
	}
	
	private void initSound(){
			/*try {
			new Sound("../../andhisnameis.aiff").play();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void start(){

		clear();
		Camera.setData(data);
		this.initLevel();
		this.initSound();
		this.initPlayer();
		this.data.getUniverse().addGameEntity(player);
		for (GameLevel level : data.getLevels()){
			currentPlayedLevel.start();
			try {
				currentPlayedLevel.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override 
	public void update(Observable o, Object arg){
		if(data.getEndOfGame().getValue()){
			restart();
		}
	}

	private void restart() {
		Runnable r = new Runnable() {	
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				start();
			}
		};
		new Thread(r).start();	
	}
	

}
