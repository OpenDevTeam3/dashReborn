package dash;

import gameframework.game.GameData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class PatternTerrain {
	
	private int size;

	private ArrayList<BlockTerrain> pattern=new ArrayList<BlockTerrain>();
	
	public PatternTerrain(String csv,GameData data) {
		try{
			File f=new File("src/main/resources/patterns/"+csv);
			FileReader ips = new FileReader(f);
			BufferedReader in = new BufferedReader(ips);
			String[] lineblocks = null;
			String s;
			BlockTerrain block;
			for(int i=0;(s=in.readLine())!=null;i++){
				lineblocks = s.split(";");
				for(int j=0;j<lineblocks.length;j++){
					
					if((block=createblock(lineblocks[j],data,j*64,i*64))!=null)
							pattern.add(block);
				}
			}
			size=lineblocks.length;	
			ips.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
	}

	private BlockTerrain createblock(String s,GameData data,int x,int y) {
		String idblock=s.split(",")[0].split(":")[0];
		  int variable=0;
		  int isWall=0;
		  if(s.split(",").length>1)
		   variable =Integer.parseInt(s.split(",")[1].split(":")[0]);
		  if(s.split(":").length>1)
		   isWall =Integer.parseInt(s.split(":")[1]);
		  switch(idblock){
		   case "0":
		    return null;
		   case "1":
		   case "2":
		   case "3":
		    if(isWall==1)
		     return new BlockTerrainWall(data, idblock, variable, x, y);
		    return new BlockTerrain(data, idblock, variable,x,y);
		   case "4":
		    return new BlockTerrainDie(data, idblock, variable,x,y);
		   case "5":
		    return new Piece(data, idblock, variable,x,y);
		   case "6":
			    return new BlockJohnCena(data, idblock, variable,x,y);
		  }
		  return null;
	}
	
	/**
	 * Retourne une liste de blocs composant un pattern.
	 * Les blocs retournés sont des clones des blocs du pattern.
	 * 
	 * @return la liste des blocs contenus dans le pattern
	 */
	public ArrayList<BlockTerrain> getPattern() {
		ArrayList<BlockTerrain> list =new ArrayList<BlockTerrain>();
		for(BlockTerrain bt : pattern)
			list.add(bt.duplique());
		return list;
	}
	
	/**
	 * Retourne le nombre de blocs du pattern en longueur.
	 * 
	 * @return la longueur du pattern
	 */
	public int getSize() {
		return size;
	}
}
