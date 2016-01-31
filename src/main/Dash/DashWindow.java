package main.Dash;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameWindow;


public class DashWindow extends GameWindow{

	
	public DashWindow(String gameName, GameCanvas gameCanvas, GameData data) {
		super(gameName, gameCanvas, data);
		
		GameLevel level=new GameLevelDash(data,50);
		data.addLevel(level);
		GameDefaultImpl game=new GameDefaultImpl(data);
		
		this.createGUI();
		
		//donne le focus au gamecanvas, pour ne pas avoir à cliquer sur la fenêtre
		this.frame.getComponent(0).requestFocusInWindow();
				
		Player player = new Player(gameCanvas,data);
		data.getUniverse().addGameEntity(player);
		
		game.start();
		
	}

	public static void main(String[] args) {
		GameData data=new GameData(new ConfigurationDash(30,50,24, 1));
		Camera.setData(data);
		new DashWindow("Dash",data.getCanvas() ,data);
	}
}
