package dash.block;

import gameframework.game.GameData;

/**
 * La classe Wall permet d'instancier des murs qui bloquent le joueur.
 * Quand le joueur rentre en collision avec un mur, il est tué, comme pour un piège.
 * 
 * @author lucasmouradeoliveira
 *
 */
public class Wall extends Platform {

	/**
	 * Crée un nouveau mur.
	 * 
	 * @param data les données de jeu
	 * @param idBlock l'identifiant de l'image du bloc
	 * @param variation l'identifiant de variation pour l'image du bloc
	 * @param x la position en abscisse du bloc
	 * @param y la position en ordonnée du bloc
	 * 
	 */
	public Wall(GameData data, String idBlock, int variation, int x, int y) {
		super(data, idBlock, variation, x, y);
	}
	
	@Override
	public Platform duplique() {
		return new Wall( data, idBlock, variation, position.x, position.y);
	}

}
