package nomicGUI;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;

import nomic.User;

public abstract class UserGUI {
	
	JFrame frame;
	
	
	UserGUI(){
	
	}
	
	public String getSuggestion(){	
		return "V�ldigt, v�ldigt viktig regel";
	}
	
	public void createWindow(String title){
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public int getVote(){
		return (int) (Math.random()*2);
	}

	public void show(HashMap<User, Integer> votes) {
		String string = "";
		Iterator<User> users = votes.keySet().iterator();
		for(int i = 0; i<votes.keySet().size();i++){
			User user = users.next();
			string += User.getName() + ": " + votes.get(user) + "\n";
		}
		
	}
}