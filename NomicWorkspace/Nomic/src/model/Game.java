package model;

import java.util.*;

public class Game extends Observable{

	public List<Player> playerList;
	public List<Rule> rules;	 
	Map<Player,Boolean> playerVotes = new HashMap<Player, Boolean>();
	Rule currentSuggestion = new Rule(0, "Placeholder");
	int votes = 0;
	int currentPlayer = 0;

	public Game(){	
		playerList = new ArrayList<Player>();
		rules = new LinkedList<Rule>();
	}

	Game(String fileName){
//		Load a game from "fileName"
	}
	
	public void play(){
//		Game Logic
	}
	
	public void vote(Player player, boolean vote){
		playerVotes.put(player, vote);
		votes++;
		if(votes==playerList.size()){
			playerVotes.clear();
			this.notify();
			votes = 0;
		}
		setChanged();
		notifyObservers();
	}
	
	public void addPlayer(){
		playerList.add(new Player("Player " + (playerList.size()+1)));
		setChanged();
		notifyObservers();
	}
	
	public void addPlayer(String name){
		playerList.add(new Player(name));
		setChanged();
		notifyObservers();
	}
	
	public void addRule(String rule){
		currentSuggestion = new Rule((rules.size()+1), rule);
		rules.add(currentSuggestion);
		setChanged();
		notifyObservers();
	}
	
	public void removePlayer(int player){
		playerList.remove(player-1);
		setChanged();
		notifyObservers();
	}
	
	public void nextPlayer(){
		currentPlayer = (currentPlayer+1)%playerList.size();
		setChanged();
		notifyObservers();
	}
	
	public int getCurrentPlayer(){
		return currentPlayer;
	}
	
	public Rule getCurrentSuggestion(){
		return currentSuggestion;
	}

	public void setRuleActive(int id, boolean b) {
		// TODO Auto-generated method stub
		rules.get(id).setActive(b);
		setChanged();
		notifyObservers();
	}
}
