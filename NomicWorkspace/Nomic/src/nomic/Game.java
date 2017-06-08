package nomic;

import java.util.*;

public class Game {

	List<Player> userList;
	List<Rule> rules;
	boolean playing = false;	
	Map<Player,Integer> score;
	Map<Player,Integer> votes;

	Game(int players){	
		userList = new ArrayList<Player>();
		for(int i=0;i<players;i++){
			userList.add(new Player("Spelare" + i));
		}
		rules = new LinkedList<Rule>();
	}

	Game(String fileName){
//		Load a game from "fileName"
	}
	
	public void play(){
//		Game Logic
	}
	
	private void vote(Rule rule){
		
	}
	
	public void setScore(String name, int score){
		Iterator<Player> iterator = userList.iterator();
		Player player;
		while(iterator.hasNext()){
			player = iterator.next();
			if(player.getName().equals(name)){
				player.setScore(score);
			}
		}
	}
}
