package main.Dash;

import gameframework.drawing.BackgroundImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;
	
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Iterator;
	
public class GameUniverseViewPortDash implements GameUniverseViewPort {

	private Image buffer;
	protected BackgroundImage background;
	protected GameData data;
	protected URL backgroundImage(String path) {
		return this.getClass().getResource(path);
	}

	public GameUniverseViewPortDash() {}

	public GameUniverseViewPortDash(GameData data) {
		setGameData(data);
	}

	protected URL backgroundImage() {
		return backgroundImage("paysage.jpg");
	}

	@Override
	public void paint() {
		background.draw(getBufferGraphics());
		Iterator<GameEntity> gt = getUniverse().getGameEntitiesIterator();
		Camera.getInstance().moveCamera();
		for (; gt.hasNext();) {
			GameEntity tmp = gt.next();
			tmp.draw(getBufferGraphics());
		}
		refresh();
	}
	
	protected GameUniverse getUniverse() {
		return data.getUniverse();
	}

	public GameCanvas getCanvas() {
		return data.getCanvas();
	}

	@Override
	public void setGameData(GameData data) {
		this.data = data;
		buffer = getCanvas().createBuffer();
		background = new BackgroundImage(backgroundImage(), getCanvas());
	}

	protected Graphics getBufferGraphics() {
		return buffer.getGraphics();
	}

	@Override
	public void refresh() {
		getCanvas().drawFullSizeImage(buffer);
	}

	@Override
	public void setBackgroundImage(String path) {
		// TODO Auto-generated method stub
		
	}
}

