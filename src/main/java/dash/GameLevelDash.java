package dash;

import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;


public class GameLevelDash extends GameLevelDefaultImpl {

	public GameLevelDash(GameData data,int delay) {
		super(data,delay);
	}

	@Override
	protected void init() {
		gameBoard=new GameUniverseViewPortDash(data);
	}
	
	public GameUniverseViewPort getBoard(){
		return gameBoard;
	}

}
