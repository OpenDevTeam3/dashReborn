package dash;

import gameframework.assets.Sound;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameWindow;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class DashWindow extends GameWindow{

	
	public DashWindow(String gameName, GameCanvas gameCanvas, GameData data) {
		super(gameName, gameCanvas, data);
		
		GameLevel level=new GameLevelDash(data,25);
		data.addLevel(level);
		GameDefaultImpl game=new GameDefaultImpl(data);
		
		this.createGUI();
		
		//donne le focus au gamecanvas, pour ne pas avoir à cliquer sur la fenêtre
		this.frame.getComponent(0).requestFocusInWindow();
				
		Player player = new Player(gameCanvas,data);
		data.getUniverse().addGameEntity(player);
		
		/*try {
			new Sound("../../andhisnameis.aiff").play();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}*/
		game.start();
		
	}

	public static void main(String[] args) {
		GameData data=new GameData(new ConfigurationDash(30,50,24, 1));
		Camera.setData(data);
		new DashWindow("Dash",data.getCanvas() ,data);
	}
}
