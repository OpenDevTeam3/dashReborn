package dash.terrain;

import gameframework.game.GameData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import dash.block.Platform;
import dash.game.ConfigurationDash;


public class GenerateurTerrain {

	private ArrayList<PatternTerrain> patternTerrains;
	
	private int genPosX;
	
	private static final int LARGEUR_GENERE=2000; 
	
	private Random random;
	
	private GameData data;
	
	/**
	 * Crée un nouveau générateur de terrain et charge une liste de patterns dans les ressources du projet.
	 * 
	 * @param data les données de jeu
	 */
	public GenerateurTerrain(GameData data) {
		this.data=data;
		genPosX = 0;
		random = new Random();
		patternTerrains = new ArrayList<PatternTerrain>();
		patternTerrains.add(new PatternTerrain("pattern8.csv", data));
		patternTerrains.add(new PatternTerrain("pattern9.csv", data));
		patternTerrains.add(new PatternTerrain("pattern10.csv", data));
		patternTerrains.add(new PatternTerrain("pattern11.csv", data));
		patternTerrains.add(new PatternTerrain("pattern12.csv", data));
		patternTerrains.add(new PatternTerrain("pattern13.csv", data));
		patternTerrains.add(new PatternTerrain("pattern14.csv", data));
		
	}
	
	/**
	 * Génère le terrain à partir de la position sur l'axe x passée en paramètre.
	 * 
	 * @param positionX la position à partir de laquelle le générateur va créer le terrain
	 */
	public void generate(int positionX) {
		if(positionX+LARGEUR_GENERE>genPosX){
			generateTerrain(getRandomPattern());
		}
	}
	
	/**
	 * Retourne un pattern de terrain aléatoire dans la liste des patterns préchargés.
	 * 
	 * @return un pattern de blocs aléatoire
	 */
	public PatternTerrain getRandomPattern(){
		return patternTerrains.get(random.nextInt(patternTerrains.size()));
	}

	/**
	 * Ajoute une liste de bloc au jeu en fonction du pattern choisi.
	 * 
	 * @param pattern le pattern de bloc
	 */
	public void generateTerrain(PatternTerrain pattern){
		ArrayList<Platform> bts= pattern.getPattern();
		Platform block;
		Iterator<Platform> bt=bts.iterator();
		while(bt.hasNext()) {
			block=bt.next();
			block.offset(genPosX);
			data.getUniverse().addGameEntity(block);
		}
		genPosX+=pattern.getSize()*((ConfigurationDash)data.getConfiguration()).getBlockSize();
		
	}

	public void reset() {
		genPosX = 0;
	}
}
