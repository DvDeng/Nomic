package test;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Nomic");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JLabel test = new JLabel("Hi");
		frame.getContentPane().add(test);
		frame.setVisible(true);
	}

}