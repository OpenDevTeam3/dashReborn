package dash;

import gameframework.game.GameData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class GenerateurTerrain {

	private ArrayList<PatternTerrain> patternTerrains=new ArrayList<PatternTerrain>();
	private int dejaGenere=0;
	private static final int LARGEUR_GENERE=2000; 
	private Random r=new Random();
	private GameData data;
	
	public GenerateurTerrain(GameData data) {
		this.data=data;
		
		patternTerrains.add(new PatternTerrain("pattern7.csv", data));
	}
	
	public void generate(int x) {
	
		if(x+LARGEUR_GENERE>dejaGenere){
			generateTerrain(patternTerrains.get(r.nextInt(patternTerrains.size())));
		}
	}

	public void generateTerrain(PatternTerrain pattern){
		ArrayList<BlockTerrain> bts= pattern.getPatern();
		BlockTerrain block;
		Iterator<BlockTerrain> bt=bts.iterator();
		while(bt.hasNext()) {
			block=bt.next();
			block.setPositionCamera(dejaGenere);
			data.getUniverse().addGameEntity(block);
		}
		dejaGenere+=30*64;
		
	}
}
