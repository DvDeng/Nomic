package nomic;

import java.util.Map;

public class Game {

	int currentPlayer;
	User[] userList;
	boolean playing = false;
	Map<Integer,Rule> ruleset;
	Map<User,Integer> score;

	Game(int players){
		User[] userList = new User[players];
		userList[0] = new Moderator();
		for(int i = 1;i<players;i++){
			userList[i] = new Player(); 
		}
		currentPlayer = (int)(Math.random()*players);
	}

	public void load(String filename){

	}

	public void play(){
		while(playing){
			userList[currentPlayer].takeTurn(this);
			currentPlayer = (currentPlayer++)%userList.length;
		}	
	}

	public void addRule(Rule rule, int id){
		ruleset.put(id, rule);
	}

}