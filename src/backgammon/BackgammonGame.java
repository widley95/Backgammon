package backgammon;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import userInterface.BackgammonUI;

public class BackgammonGame {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InterruptedException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		BackgammonUI gameBoard = new BackgammonUI(); 
		Thread.sleep(10000);
	}

}
