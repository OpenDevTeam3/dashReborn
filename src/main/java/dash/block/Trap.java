package dash.block;

import gameframework.game.GameData;

/**
 * La classe Trap permet d'instancier des blocs de pièges, qui tuent le joueur quand il marche dessus.
 * 
 * @author lucasmouradeoliveira
 *
 */
public class Trap extends Platform {

	/**
	 * Crée un nouveau piège.
	 * 
	 * @param data les données de jeu
	 * @param idBlock l'identifiant de l'image du bloc
	 * @param variation l'identifiant de variation pour l'image du bloc
	 * @param x la position en abscisse du bloc
	 * @param y la position en ordonnée du bloc
	 * 
	 */
	public Trap(GameData data, String idBlock, int variation, int x, int y) {
		super(data, idBlock, variation, x, y);
	}

	@Override
	public Platform duplique() {
		return new Trap( data, idBlock, variation, position.x, position.y);
	}
}
