/*
 * Class to contain each and every
 * UI element of the game
 */

import javax.swing.*;


public class BackgammonUI
{

	private JFrame boardFrame; 
	
	public BackgammonUI()
	{
		initComponents();
	}
	
	private void initComponents()
	{
		boardFrame = new JFrame("Backgammon"); 
		boardFrame.setSize(1000, 850);
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setVisible(true);
	}
}
