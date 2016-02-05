package dash.game;

import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameUniverse;
import dash.entities.Player;
import dash.terrain.GenerateurTerrain;
import dash.util.Camera;

public class GameLevelDash extends Thread{
	
	protected GameData data;
	
	protected GameUniverse universe;
	
	protected GameUniverseViewPortDash board;
	
	protected ConfigurationDash config;
	
	protected Camera camera;

	protected Player player;
	
	protected GenerateurTerrain generateur;
	
	protected long delay;
	
	protected boolean endLevel;
	
	protected boolean accelerated;

	public GameLevelDash(GameData data,long delay) {
		this.data = data;
		this.universe = data.getUniverse();
		this.board = new GameUniverseViewPortDash(data);
		this.config = (ConfigurationDash) data.getConfiguration();
		this.camera = config.getCamera();
		this.delay = delay;
		this.generateur = new GenerateurTerrain(data);
	}

	protected void init() {
		this.endLevel = false;
		this.accelerated = false;
		this.resetUniverse();
		this.initPlayer();	
		this.initScore();
		this.camera.setCameraOnPlayer(player);
		this.generateur.reset();
	}
	
	public void initPlayer(){
		this.player = new Player(data.getCanvas(), data);
		this.player.setPosition(config.getPlayerSpawnLocation());
		this.universe.addGameEntity(player);
	}
	
	public void initScore(){
		this.config.getScore().reset();
		this.universe.addGameEntity(config.getScore());
	}
	
	public void resetUniverse(){
		data.getEndOfGame().setValue(false);
		this.universe.removeAllGameEntities();
	}
	
	public GameUniverseViewPort getBoard(){
		return board;
	}
	
	@Override
	public void run() {
			
		long start;
		long sleepTime;
		
		while(true){
			init();
			while (!endLevel) {
				start = System.currentTimeMillis();
				update();
				sleepTime = delay - (System.currentTimeMillis() - start);
				if (sleepTime > 0) {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {}
				}
			}
		}
	}
	
	private void update() {
		board.paint();
		universe.allOneStepMoves();
		universe.processAllOverlaps();
		camera.setCameraOnPlayer(player);
		generateur.generate(camera.getX());
		player.accelerate();
	}

	public void restart() {
		this.endLevel = true;
	}

}