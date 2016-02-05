package dash.block;

import gameframework.game.GameData;


/**
 * Un bloc en forme de pièce que le joueur peut ramasser pour gagner des points.
 * 
 * @author lucasmouradeoliveira
 *
 */
public class Coin extends Platform {

	/**
	 * Crée une nouvelle pièce.
	 * 
	 * @param data les données de jeu
	 * @param idBlock l'identifiant de l'image du bloc
	 * @param variation l'identifiant de variation pour l'image du bloc
	 * @param x la position en abscisse du bloc
	 * @param y la position en ordonnée du bloc
	 */
	public Coin(GameData data, String idBlock, int variation, int x, int y) {
		super(data, idBlock, variation, x, y);
	}

	/**
	 * Augmente le score du joueur.
	 */
	public void addscore(){
		config.getScore().addScore(config.getCoinScore());
		data.getUniverse().removeGameEntity(this);
	}
	
	@Override
	public Platform duplique() {
		return new Coin( data, idBlock, variation, position.x, position.y);
	}
}
