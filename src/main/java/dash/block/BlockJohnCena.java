package dash.block;

import gameframework.game.GameData;

import java.awt.Color;
import java.awt.Graphics;

import dash.game.GameLevelDash;


/**
 * La classe BlockJohnCena permet d'ajouter un peu de catch au jeu, en faisant apparaitre la star de la WWE.
 * .
 * @author lucasmouradeoliveira
 *
 */
public class BlockJohnCena extends Platform {

	/**
	 * Crée un bloc-surprise qui fait apparait John Cena quand le joueur passe dessus.
	 * 
	 * @param data les données de jeu
	 * @param idBlock l'identifiant de l'image du bloc
	 * @param variation l'identifiant de variation pour l'image du bloc
	 * @param x la position en abscisse du bloc
	 * @param y la position en ordonnée du bloc
	 * 
	 */
	public BlockJohnCena(GameData data, String idBlock, int variation, int x, int y) {
		super(data, idBlock, variation, x, y);
	}
	
	@Override
	public void draw(Graphics g){
		//you can't see me
		g.setColor(Color.RED);
		g.drawRect(position.x-camera.getX(),position.y-camera.getY(), config.getBlockSize(), config.getBlockSize());
	}
	
	@Override
	public Platform duplique() {
		return new BlockJohnCena( data, idBlock, variation, position.x, position.y);
	}

	/**
	 * Remplace le fond d'écran par un gif de John Cena.
	 */
	@Deprecated
	public void johnCena() {
		((GameLevelDash)data.getLevels().get(0)).getBoard().setBackgroundImage("/cena.gif");
		data.getUniverse().removeGameEntity(this);
	}
}
