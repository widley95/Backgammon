package userInterface;
/*
 * Class to contain each and every
 * UI element of the game
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BackgammonUI
{

	private JFrame boardFrame; 
	public 	JComponent mainContainer; 

	
	public BackgammonUI() throws IOException
	{
		initComponents();
	}
	
	private void initComponents() throws IOException
	{
		// Declare all components
		JPanel buttonsPanel; 
		JButton singlePlayerButton; 
		JButton multiPlayerButton; 
		JButton quitButton; 
		Font buttonsFont; 
		JLabel imageLabel; 

		// main board JFrame
		boardFrame = new JFrame("Backgammon"); 
		boardFrame.setSize(1150, 900);
		// main content pane 
		mainContainer = (JComponent) boardFrame.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		mainContainer.setBackground(Color.DARK_GRAY);
		
		// font to be used by the buttons on the home page
		buttonsFont = new Font("Arial", Font.BOLD, 30); 
		
		// set up different jpanel for the buttons 
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		buttonsPanel.setPreferredSize(new Dimension(350, 10));
		buttonsPanel.add(Box.createRigidArea(new Dimension(0,300)));
		buttonsPanel.setBackground(Color.DARK_GRAY);
		
		// single player button 
		singlePlayerButton = new JButton("Single");
		singlePlayerButton.setToolTipText("Click to play against the computer");
		singlePlayerButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		singlePlayerButton.setMaximumSize(new Dimension(250,70));
		singlePlayerButton.setActionCommand("Single");
		singlePlayerButton.setFont(buttonsFont);
		singlePlayerButton.addActionListener(new PlayerListener());
		buttonsPanel.add(singlePlayerButton);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0,15)));
		
		// multi player button 
		multiPlayerButton = new JButton("Multiplayer");
		multiPlayerButton.setToolTipText("Click to play against a friend");
		multiPlayerButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		multiPlayerButton.setMaximumSize(new Dimension(250, 70));
		multiPlayerButton.setActionCommand("Multiplayer");
		multiPlayerButton.setFont(buttonsFont);
		multiPlayerButton.addActionListener(new PlayerListener());
		buttonsPanel.add(multiPlayerButton);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0,15)));
		
		// quit button 
		quitButton = new JButton("Quit"); 
		quitButton.setToolTipText("Click to Quit game");
		quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		quitButton.setMaximumSize(new Dimension(250, 70));
		quitButton.setFont(buttonsFont);
		quitButton.addActionListener(new QuitListener());
		buttonsPanel.add(quitButton);
		
		// seperate label for background image
		imageLabel = new JLabel(); 
		// resize the image icon so it can fit in the jlabel 
		imageLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Backgammonboard.jpg"))
				.getImage().getScaledInstance(790, 750, Image.SCALE_SMOOTH)));
	
	
		imageLabel.setBorder(BorderFactory.createRaisedBevelBorder());
		imageLabel.setMaximumSize(new Dimension(100, 100));
						
		// add everything to the main container 
		mainContainer.add(buttonsPanel, BorderLayout.LINE_END);
		mainContainer.add(imageLabel, BorderLayout.CENTER);
		mainContainer.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.PAGE_START);
		mainContainer.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.PAGE_END);
	
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setResizable(false);
		boardFrame.setVisible(true);
	}
	
	
	private class QuitListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game ?", 
                    "Quit", JOptionPane.YES_NO_OPTION);
            
            if (response == JOptionPane.YES_OPTION)
                System.exit(0);	
		}
	}
	
	private class PlayerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String buttonClicked = ((JButton) e.getSource()).getActionCommand(); 
			Font labelFonts = new Font("Arial", Font.BOLD, 18);
			JDialog playerDialogBox = new JDialog(boardFrame, buttonClicked, true);
			playerDialogBox.setSize(new Dimension(800,500));
			playerDialogBox.setLocationRelativeTo(boardFrame);
			playerDialogBox.setAlwaysOnTop(true);
	
			JPanel playerPanel = new JPanel();
			playerPanel.setBackground(Color.LIGHT_GRAY);
			GroupLayout groupLayout = new GroupLayout(playerPanel);
			playerPanel.setLayout(groupLayout);
			
			JTextField playerOneNameField = new JTextField();
			playerOneNameField.setMaximumSize(new Dimension(550, 20));
			JLabel nameOneLabel = new JLabel("Name");
			nameOneLabel.setFont(labelFonts);
			JLabel colorLabel = new JLabel("Color"); 
			colorLabel.setFont(labelFonts);
			JLabel playToLabel = new JLabel("Play To"); 
			playToLabel.setFont(labelFonts);
			JLabel difficultyLabel = new JLabel("Difficulty"); 
			difficultyLabel.setFont(labelFonts);
			JButton easyButton = new JButton("Easy");
			JButton mediumButton = new JButton("Medium");
			JButton hardButton = new JButton("Hard");
			JButton playToOne = new JButton("1"); 
			JButton playToThree = new JButton("3"); 
			JButton playToFive = new JButton("5"); 
			JButton playToSeven = new JButton("7"); 
			JButton whiteColorButton = new JButton(" ");
			whiteColorButton.setBackground(Color.WHITE);
			whiteColorButton.setForeground(Color.WHITE);
			JButton blackColorButton = new JButton(" "); 
			blackColorButton.setBackground(Color.BLACK);
			blackColorButton.setForeground(Color.BLACK);
			JButton startButton = new JButton("Start");
			startButton.setToolTipText("Start Game!");
			startButton.addActionListener(new GameListener());
			startButton.setMaximumSize(new Dimension(70,30));
			JButton backButton = new JButton("Back"); 
			
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(nameOneLabel)
							.addGap(20)
							.addComponent(playerOneNameField)
							)
					.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(colorLabel)
							.addGap(25)
							.addComponent(whiteColorButton)
							.addGap(10)
							.addComponent(blackColorButton)
							)
					
					.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(playToLabel)
							.addGap(20)
							.addComponent(playToOne)
							.addGap(10)
							.addComponent(playToThree)
							)
					
					.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(difficultyLabel)
							.addGap(20)
							.addComponent(easyButton)
							)
					.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(startButton)
							.addGap(20)
							)
					);
			
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
					.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(nameOneLabel)
							.addGap(35)
							.addComponent(colorLabel)
							.addGap(35)
							.addComponent(playToLabel)
							.addGap(30)
							.addComponent(difficultyLabel)
							.addGap(40)
							.addComponent(startButton)
							)
						
					.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(playerOneNameField)
							.addGap(30)
							.addComponent(whiteColorButton)
							.addGap(25)
							.addComponent(playToOne)
							.addGap(25)
							.addComponent(easyButton)
							)
					.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(blackColorButton)
							.addGap(25)
							.addComponent(playToThree)
							
							)
					);
			if(buttonClicked.equals("Multiplayer"))
			{
				JLabel nameTwoLable = new JLabel("Name"); 
				JTextField playerTwoNameField = new JTextField(20);
			}
			
			playerPanel.add(nameOneLabel);
	//		playerPanel.add(playerOneNameField);
			playerPanel.add(colorLabel);
			playerPanel.add(playToLabel);
			playerPanel.add(difficultyLabel);
			playerPanel.setVisible(true);
			playerDialogBox.add(playerPanel);
			
			playerDialogBox.setVisible(true);
		}
		
	}
	
	/*ANDRES, start doing your shit here*/
	private class GameListener implements ActionListener

	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
}
