package main.Dash;

import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameWindow;


/**
 * 
 * DashWindow is the launcher & window of the Dash Game.
 * 
 * @author mouradeolive
 *
 */
public class DashWindow extends GameWindow{

	
	public DashWindow(String gameName, GameCanvas gameCanvas, GameData data) {
		super(gameName, gameCanvas, data);
		
		GameLevel level=new GameLevelDash(data,100);
		data.addLevel(level);
		GameDefaultImpl game=new GameDefaultImpl(data);
		
		this.createGUI();
				
		Player player = new Player(gameCanvas,data);
		data.getUniverse().addGameEntity(player);
		
		for(int i = 0 ;i<40;i++){
			BlockTerrain block = new BlockTerrain(data, "herbe", new Point(i*50,550));
			data.getUniverse().addGameEntity(block);
		}
			
		
		game.start();
		
		
	}

	public static void main(String[] args) {
		GameData data=new GameData(new ConfigurationDash(30,50,24, 1));
		Camera.setData(data);
		new DashWindow("Dash",data.getCanvas() ,data);
	}
}
