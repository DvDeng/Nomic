package nomic;

public class Nomic {
	

	
	
	Nomic(int players){
		
	}
	
	public static void Main(String[] args){
		Game g = new Game(Integer.parseInt(args[0]));
		g.play();
	}
}
