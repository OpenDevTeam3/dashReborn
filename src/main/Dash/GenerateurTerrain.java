package main.Dash;

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
		patternTerrains.add(new PatternTerrain("pattern_m2.csv", data));
		patternTerrains.add(new PatternTerrain("pattern_m3.csv", data));
		patternTerrains.add(new PatternTerrain("pattern_m4.csv", data));

		patternTerrains.add(new PatternTerrain("plateforme_b1.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b2.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b3.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b4.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b5.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b6.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b7.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b8.csv", data));
		patternTerrains.add(new PatternTerrain("plateforme_b9.csv", data));

	}
	
	public void generate(int x) {
		System.out.println("camera : "+x);
		System.out.println("dejaGenere : "+dejaGenere);

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
			System.out.println(block.getPosition());
			data.getUniverse().addGameEntity(block);
		}
		dejaGenere+=30*64;
		
	}
}
