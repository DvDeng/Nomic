package nomic;

public class Player{
	
	String name;
	int score;

	Player(String name){
		this.name = name;
		score = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	

}
