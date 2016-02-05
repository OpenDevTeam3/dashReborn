package dash.window;

import dash.game.ConfigurationDash;
import dash.game.DashGame;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;


public class DashWindow extends GameWindow{
	
	private DashGame game;

	public DashWindow(String gameName, GameCanvas gameCanvas, GameData data) {
		super(gameName, gameCanvas, data.getConfiguration());
		
		this.game=new DashGame(data);
			
		this.createGUI();
		
		//donne le focus au gamecanvas, pour ne pas avoir à cliquer sur la fenêtre
		this.frame.getComponent(0).requestFocusInWindow();
		this.game.start();
		
		
	}

	public static void main(String[] args) {
		GameData data=new GameData(new ConfigurationDash(30, 50, 24, 1));
		new DashWindow("Dash",data.getCanvas() ,data);
	}
}
