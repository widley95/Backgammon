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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.metal.MetalButtonUI;


//music


import java.io.*;
import javax.swing.*;
import sun.audio.*;
import javax.sound.sampled.*;


public class BackgammonUI 
{

	private  JFrame boardFrame; 
	private  JFrame gameFrame; 
	public 	JComponent mainContainer; 
	public int flag = 0;
	public boolean soundStatus = false;
	Thread playMusic;
	Clip clip;
	
	
	
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
		JButton help;
		JToggleButton on;
		JToggleButton off;
		JButton quitButton; 
		Font buttonsFont; 
		Font soundFont;
		JLabel imageLabel; 
		JButton musicButton;
		
		
		
		// main board JFrame
		boardFrame = new JFrame("Backgammon"); 
		boardFrame.setSize(1150, 900);
		// main content pane 
		mainContainer = (JComponent) boardFrame.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		mainContainer.setBackground(Color.DARK_GRAY);
			
		// font to be used by the buttons on the home page
		buttonsFont = new Font("Arial", Font.BOLD, 30); 
		soundFont = new Font("Arial", Font.BOLD, 20);
		
		
		// set up different jpanel for the buttons 
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		buttonsPanel.setPreferredSize(new Dimension(350, 10));
		
		// Volume On button 
				on = new JToggleButton("Volume On");
				on.setToolTipText("Click to turn volume on.");
				on.setAlignmentX(JButton.CENTER_ALIGNMENT);
				on.setMaximumSize(new Dimension(250,70));
				on.setActionCommand("On");
				on.setFont(buttonsFont);
				buttonsPanel.add(on);
				buttonsPanel.add(Box.createRigidArea(new Dimension(0,15)));
				
				// Volume Off button
				off = new JToggleButton("Volume Off");
				off.setToolTipText("Click to mute volume.");
				off.setAlignmentX(JButton.CENTER_ALIGNMENT);
				off.setMaximumSize(new Dimension(250,70));
				off.setActionCommand("Off");
				off.setFont(buttonsFont);
				buttonsPanel.add(off);
				buttonsPanel.add(Box.createRigidArea(new Dimension(0,20)));
				
		buttonsPanel.add(Box.createRigidArea(new Dimension(0,280)));
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
		
		// help button 
		help = new JButton("Help");
		help.setToolTipText("Click to play against a friend");
		help.setAlignmentX(JButton.CENTER_ALIGNMENT);
		help.setMaximumSize(new Dimension(250, 70));
		help.setActionCommand("Multiplayer");
		help.setFont(buttonsFont);
		buttonsPanel.add(help);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0,15)));
		
		// quit button 
		quitButton = new JButton("Quit"); 
		quitButton.setToolTipText("Click to Quit game");
		quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		quitButton.setMaximumSize(new Dimension(250, 70));
		quitButton.setFont(buttonsFont);
		quitButton.addActionListener(new QuitListener());
		buttonsPanel.add(quitButton);
		
		
		buttonsPanel.add(Box.createRigidArea(new Dimension(0,200)));
		
		musicButton = new JButton("Music"); 
		musicButton.setToolTipText("Click for music");
		musicButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		musicButton.setMaximumSize(new Dimension(100, 40));
		musicButton.setFont(soundFont);
		musicButton.addActionListener(new musicListener());
		buttonsPanel.add(musicButton);
		
		
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

		
		Border border = mainContainer.getBorder();
		Border margin = new EmptyBorder(10,30,10,10);
		mainContainer.setBorder(new CompoundBorder(border, margin));
		
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

			Font buttonFonts = new Font("Tahoma", 1, 20);	
	    	Font difficutlyFonts = new Font("Tahoma", 1, 15);			
       		Font playToFonts = new Font("Tahoma", 1, 15);


			JDialog playerDialogBox = new JDialog(boardFrame, buttonClicked, true);
			playerDialogBox.setSize(new Dimension(650,400));

			playerDialogBox.setLocationRelativeTo(boardFrame);
			playerDialogBox.setAlwaysOnTop(true);
	
			JPanel playerPanel = new JPanel();
			playerPanel.setBackground(Color.LIGHT_GRAY);
			GroupLayout groupLayout = new GroupLayout(playerPanel);
			playerPanel.setLayout(groupLayout);
			
			JTextField playerOneNameField = new JTextField();
			playerOneNameField.setMaximumSize(new Dimension(350, 40));
			playerOneNameField.setText("Player 1");
			playerOneNameField.setBorder(BorderFactory.createRaisedSoftBevelBorder());
			 
			JLabel nameOneLabel = new JLabel("Name");
			nameOneLabel.setFont(labelFonts);
			
			JLabel colorLabel = new JLabel("Color"); 
			colorLabel.setFont(labelFonts);
			
			JLabel playToLabel = new JLabel("Play To"); 
			playToLabel.setFont(labelFonts);
			
			JLabel difficultyLabel = new JLabel("Difficulty"); 
			difficultyLabel.setFont(labelFonts);
			
			JButton easyButton = new JButton("Easy");
			easyButton.setFont(difficutlyFonts);
			
			JButton mediumButton = new JButton("Medium");
			mediumButton.setFont(difficutlyFonts);
			
			JButton hardButton = new JButton("Hard");
			hardButton.setFont(difficutlyFonts);
			
			JButton playToOne = new JButton("1"); 
			playToOne.setFont(playToFonts);
			
			JButton playToThree = new JButton("3"); 
			playToThree.setFont(playToFonts);
			
			JButton playToFive = new JButton("5"); 
			playToFive.setFont(playToFonts);
			
			JButton playToSeven = new JButton("7"); 
			playToSeven.setFont(playToFonts);
			

			/*
>>>>>>> Fixed merged conflicts
			JButton whiteColorButton = new JButton();
			whiteColorButton.setBackground(Color.WHITE);
			playerDialogBox.add(whiteColorButton);
			whiteColorButton.setUI( new MetalButtonUI( ));
			whiteColorButton.setOpaque(true);
			whiteColorButton.setBorderPainted(true);
			
			JButton blackColorButton = new JButton(); 
<<<<<<< 07b61ba378faff444de6897c2e2fe2628f7607fa
			playerDialogBox.add(blackColorButton);
			blackColorButton.setUI( new BasicButtonUI( ));
			blackColorButton.setBackground(Color.BLACK);
			blackColorButton.setOpaque(true);
			blackColorButton.setBorderPainted(true);
			
			 
			JButton startButton = new JButton("Start");
			startButton.setToolTipText("Start Game!");
			startButton.addActionListener(new GameListener());
			startButton.setFont(buttonFonts);
			 
=======
			blackColorButton.setBackground(Color.black);
			*/
			JButton startButton = new JButton("Start");
			startButton.setToolTipText("Start Game!");
			startButton.addActionListener(new GameListener(playerDialogBox));
			startButton.setFont(buttonFonts);

			JButton backButton = new JButton("Back"); 
			backButton.setFont(buttonFonts);
			backButton.addActionListener(new BackButtonListener(playerDialogBox));

			playerOneNameField.setMaximumSize(new Dimension(350, 40));
			playerOneNameField.setText("Player 1");
			playerOneNameField.setBorder(BorderFactory.createRaisedSoftBevelBorder());
			 
			
			JButton whiteColorButton = new JButton();
			whiteColorButton.setBackground(Color.WHITE);
			whiteColorButton.setUI( new MetalButtonUI( ));
			whiteColorButton.setOpaque(true);
			whiteColorButton.setBorderPainted(true);
			
			JButton blackColorButton = new JButton(); 
			blackColorButton.setUI( new BasicButtonUI( ));
			blackColorButton.setBackground(Color.BLACK);
			blackColorButton.setOpaque(true);
			blackColorButton.setBorderPainted(true);		
			 		

			if (buttonClicked.equals("Single"))
			{
				groupLayout.setHorizontalGroup(groupLayout.createParallelGroup()
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
								.addComponent(whiteColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(blackColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								)
						
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(playToLabel)
								.addGap(20)
								.addComponent(playToOne, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(playToThree, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(playToFive, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(playToSeven, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								)
						
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(difficultyLabel)
								.addGap(20)
								.addComponent(easyButton, GroupLayout.PREFERRED_SIZE,70, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(mediumButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(hardButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(108)
								.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(80)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								)
						);
				
				groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(20)
								.addComponent(nameOneLabel)
								.addGap(43)
								.addComponent(colorLabel)
								.addGap(35)
								.addComponent(playToLabel)
								.addGap(45)
								.addComponent(difficultyLabel)
								.addGap(40)
								)
							
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(playerOneNameField)
								.addGap(17)
								.addComponent(whiteColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(21)
								.addComponent(playToOne, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(25)
								.addComponent(easyButton, GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(72)
								.addComponent(blackColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(21)
								.addComponent(playToThree, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(133)
								.addComponent(playToFive, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(133)
								.addComponent(playToSeven, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(mediumButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(203)
								.addComponent(hardButton, GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
								)
						);
			}

			else
			{
				JLabel playerOneLabel = new JLabel("Player 1"); 
				playerOneLabel.setFont(labelFonts);
				JLabel playerTwoLabel = new JLabel("Player 2"); 
				playerTwoLabel.setFont(labelFonts);
				JTextField playerTwoNameField = new JTextField();
				playerTwoNameField.setMaximumSize(new Dimension(350, 40));
				playerTwoNameField.setText("Player 2");
				playerTwoNameField.setBorder(BorderFactory.createRaisedSoftBevelBorder());
				groupLayout.setHorizontalGroup(groupLayout.createParallelGroup()
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(playerOneLabel)
								.addGap(20)
								.addComponent(playerOneNameField)
								.addGap(25)
								.addComponent(whiteColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(playerTwoLabel)
								.addGap(20)
								.addComponent(playerTwoNameField)
								.addGap(25)
								.addComponent(blackColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								)
						
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(playToLabel)
								.addGap(20)
								.addComponent(playToOne, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(playToThree, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(playToFive, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(playToSeven, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								)
						
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(difficultyLabel)
								.addGap(20)
								.addComponent(easyButton, GroupLayout.PREFERRED_SIZE,70, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(mediumButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(hardButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(108)
								.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(80)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								)
						);
				
				groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(20)
								.addComponent(playerOneLabel)
								.addGap(43)
								.addComponent(playerTwoLabel)
								.addGap(35)
								.addComponent(playToLabel)
								.addGap(45)
								.addComponent(difficultyLabel)
								.addGap(40)
								)
							
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(playerOneNameField)
								.addGap(17)
								.addComponent(playerTwoNameField)
								.addGap(21)
								.addComponent(playToOne, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(25)
								.addComponent(easyButton, GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(72)
								.addComponent(blackColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(21)
								.addComponent(playToThree, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(133)
								.addComponent(playToFive, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(133)
								.addComponent(playToSeven, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(mediumButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(203)
								.addComponent(hardButton, GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
								)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(whiteColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(blackColorButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								)
						);
			}
			playerPanel.setVisible(true);
			playerDialogBox.add(playerPanel);

			playerDialogBox.setVisible(true);
		}
		
	}
	

	private class BackButtonListener implements ActionListener
	{
		JDialog dialogBox; 
		BackButtonListener(JDialog dialogBox)
		{
			this.dialogBox = dialogBox; 
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			dialogBox.dispose();
		}
	}
	
	private class GameListener implements ActionListener

	{
		JDialog dialogBox; 
		JLabel rollLabel;
		
		GameListener()
		{
		}
		GameListener(JDialog dialogBox)
		{
			this.dialogBox = dialogBox; 
		}
			
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (dialogBox != null)
			{
				dialogBox.dispose();
			}
			mainContainer.removeAll();
			mainContainer.revalidate();
			mainContainer.repaint();
			
			JPanel buttonsPanel1; 
			JButton resetButton; 
			JButton quitButton; 
			JButton dieButton;
			JButton mainMenuButton;
			Font buttonsFont; 
			JLabel boardLabel = new JLabel(); 
			JLabel diceLabel;
			Font dieFont;
			
			JButton musicButton;
			//JLabel rollLabel;
			dieFont = new Font("Arial", Font.BOLD, 20); 
			Font soundFont = new Font("Arial", Font.BOLD, 20);
			
			boardLabel = new JLabel(); 
			// resize the image icon so it can fit in the jlabel 
			boardLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("board.jpg"))
					.getImage().getScaledInstance(790, 750, Image.SCALE_SMOOTH)));
			
		
			boardLabel.setBorder(BorderFactory.createRaisedBevelBorder()); //remove this border
			boardLabel.setMaximumSize(new Dimension(100, 100));
			
			buttonsFont = new Font("Arial", Font.BOLD, 30); 
			
			// set up different jpanel for the buttons 
			buttonsPanel1 = new JPanel();
			buttonsPanel1.setLayout(new BoxLayout(buttonsPanel1, BoxLayout.Y_AXIS));
			buttonsPanel1.setPreferredSize(new Dimension(350, 50));
			//buttonsPanel1.add(Box.createRigidArea(new Dimension(20,300)));
			buttonsPanel1.setBackground(Color.DARK_GRAY);
			
			
			
			diceLabel = new JLabel();
			diceLabel.setText("Roll the Die!");
			diceLabel.setForeground(Color.WHITE);
			diceLabel.setFont(dieFont);
			diceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			diceLabel.setAlignmentY(JButton.TOP_ALIGNMENT);
			buttonsPanel1.add(diceLabel);
			
			buttonsPanel1.add(Box.createRigidArea(new Dimension(0,20)));
			
			
			dieButton = new JButton();
			try {
			    Image img = ImageIO.read(getClass().getResource("die.jpg"));
			    dieButton.setIcon(new ImageIcon(img));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
			dieButton.setBorder(BorderFactory.createEmptyBorder());
			dieButton.setContentAreaFilled(false);
		
			dieButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			dieButton.setAlignmentY(JButton.TOP_ALIGNMENT);
			//dieButton.setMaximumSize(new Dimension(250,70));
			//dieButton.addActionListener(new dieListener());
			//dieButton.setActionCommand("Reset");
			
			
			buttonsPanel1.add(dieButton);
			//buttonsPanel1.add(Box.createRigidArea(new Dimension(0,15)));
			
			
			buttonsPanel1.add(Box.createRigidArea(new Dimension(0,20)));
			
			rollLabel = new JLabel();
			//rollLabel.setText("Roll the Die!");   //SET TEXT HERE
			rollLabel.setForeground(Color.WHITE);
			rollLabel.setFont(dieFont);
			rollLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			
			dieButton.addActionListener(new dieListener(rollLabel));
			buttonsPanel1.add(rollLabel);
		
			
			buttonsPanel1.add(Box.createRigidArea(new Dimension(0,150)));
			
			resetButton = new JButton("Reset");
			resetButton.setToolTipText("Start Fresh!");
			resetButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			resetButton.setMaximumSize(new Dimension(250,70));
			resetButton.setActionCommand("Reset");
			resetButton.setFont(buttonsFont);
			resetButton.addActionListener(new GameListener());
			
			
			mainMenuButton = new JButton("Main Menu");
			mainMenuButton.setToolTipText("Back to Main Menu!");
			mainMenuButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			mainMenuButton.setMaximumSize(new Dimension(250,70));
			mainMenuButton.setActionCommand("Main Menu");
			mainMenuButton.setFont(buttonsFont);
			
			 
			
			buttonsPanel1.add(resetButton);
			buttonsPanel1.add(Box.createRigidArea(new Dimension(0,15)));
			
			
			
			// quit player button 
			quitButton = new JButton("Quit");
			quitButton.setToolTipText("Go Back to Main Screen");
			quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			quitButton.setMaximumSize(new Dimension(250, 70));
			quitButton.setActionCommand("Quit");
			quitButton.setFont(buttonsFont);
			
			
			
			musicButton = new JButton("Music"); 
			musicButton.setToolTipText("Click for music");
			musicButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			musicButton.setMaximumSize(new Dimension(100, 40));
			musicButton.setFont(soundFont);
			musicButton.addActionListener(new musicListener());
			
			
			
			
			buttonsPanel1.add(mainMenuButton);
			buttonsPanel1.add(Box.createRigidArea(new Dimension(0,15)));
			
			
			
			buttonsPanel1.add(quitButton);
			buttonsPanel1.add(Box.createRigidArea(new Dimension(0,150)));
			
			
			buttonsPanel1.add(musicButton);
			
							
			// add everything to the main container 
			
			mainContainer.add(buttonsPanel1, BorderLayout.LINE_END);
			mainContainer.add(boardLabel, BorderLayout.CENTER);
			mainContainer.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.PAGE_START);
			mainContainer.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.PAGE_END);
			
		//	Border border = mainContainer.getBorder();
			//Border margin = new EmptyBorder(10,30,10,10);
		//	mainContainer.setBorder(new CompoundBorder(border, margin));
			
			quitButton.addActionListener(new QuitListener());
			resetButton.addActionListener(new GameListener()); 
			mainMenuButton.addActionListener(new mainMenuListener());
			
			
			
			boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			boardFrame.setResizable(false);
			boardFrame.setVisible(true);
			
			
		}
	}
	

	
	
	private class mainMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)
		{

			
			mainContainer.removeAll();
			mainContainer.revalidate();
			mainContainer.repaint();
			
			JPanel buttonsPanel; 
			JButton singlePlayerButton; 
			JButton multiPlayerButton;
			JButton help;
			JToggleButton on;
			JToggleButton off;
			JButton quitButton; 
			Font buttonsFont; 
			JLabel imageLabel; 
			JButton musicButton;
			
			Font soundFont = new Font("Arial", Font.BOLD, 20);
			buttonsFont = new Font("Arial", Font.BOLD, 30); 
		
			
			buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
			buttonsPanel.setPreferredSize(new Dimension(350, 10));
			
			// Volume On button 
			on = new JToggleButton("Volume On");
			on.setToolTipText("Click to turn on volume.");
			on.setAlignmentX(JButton.CENTER_ALIGNMENT);
			on.setMaximumSize(new Dimension(250,70));
			on.setActionCommand("On");
			on.setFont(buttonsFont);
			//on.addActionListener(new PlayerListener());
			buttonsPanel.add(on);
			buttonsPanel.add(Box.createRigidArea(new Dimension(0,15)));
			
			// Volume Off button
			off = new JToggleButton("Volume Off");
			off.setToolTipText("Click to mute volume.");
			off.setAlignmentX(JButton.CENTER_ALIGNMENT);
			off.setMaximumSize(new Dimension(250,70));
			off.setActionCommand("Off");
			off.setFont(buttonsFont);
			//on.addActionListener(new PlayerListener());
			buttonsPanel.add(off);
			buttonsPanel.add(Box.createRigidArea(new Dimension(0,20)));
			
			buttonsPanel.add(Box.createRigidArea(new Dimension(0,250)));
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
			
			// help button 
			help = new JButton("Help");
			help.setToolTipText("Click to play against a friend");
			help.setAlignmentX(JButton.CENTER_ALIGNMENT);
			help.setMaximumSize(new Dimension(250, 70));
			help.setActionCommand("Multiplayer");
			help.setFont(buttonsFont);
			buttonsPanel.add(help);
			buttonsPanel.add(Box.createRigidArea(new Dimension(0,15)));
			
			
			// quit button 
			quitButton = new JButton("Quit"); 
			quitButton.setToolTipText("Click to Quit game");
			quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			quitButton.setMaximumSize(new Dimension(250, 70));
			quitButton.setFont(buttonsFont);
			quitButton.addActionListener(new QuitListener());
			buttonsPanel.add(quitButton);
			
			
			
			buttonsPanel.add(Box.createRigidArea(new Dimension(0,200)));
			
			musicButton = new JButton("Music"); 
			musicButton.setToolTipText("Click for music");
			musicButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			musicButton.setMaximumSize(new Dimension(100, 40));
			musicButton.setFont(soundFont);
			musicButton.addActionListener(new musicListener());
			buttonsPanel.add(musicButton);
			
			
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
	}
	
	
	// update the rollLabel JLabel when the dice are rolled
	private class dieListener implements ActionListener{
		
		private JLabel labels;
		public dieListener(JLabel rollLabel){
			this.labels = rollLabel;
			
			
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			
			Random rand = new Random();
			int ranumFirst = rand.nextInt(6)+1;
			int ranumSecond = rand.nextInt(6)+1;
		
			System.out.println(ranumFirst + " and " + ranumSecond );
			
			labels.setText(ranumFirst + " and " + ranumSecond);
			
			
		
			
			
				
			
			
			
			
		}
	}
	
	
	
	
	public class musicListener implements ActionListener {
		//String name = "src/userinterface/maskoff";
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			 
			musicThread runmT = new musicThread();
			Thread myThread = new Thread(runmT);
			myThread.start();
			
			 if(soundStatus == true){
				  clip.stop();
				  soundStatus = false;
				  myThread.stop();
				  
				  }
		
			
		}	
		
		
		
		
		}
	
	public class musicThread implements Runnable{

		@Override
		public void run() {
			String name = "src/userinterface/maskoff";
			
			
			if(soundStatus == false){
			
			
			try {
				  File file = new File(name + ".wav");
				  clip = AudioSystem.getClip();
				  clip.open(AudioSystem.getAudioInputStream(file));
				  
				  
				  
					  clip.start();
					  soundStatus = true;
				  
				 // if(soundStatus == true){
					//  clip.stop();
					  //soundStatus = false;
					//  }
				  Thread.sleep(clip.getMicrosecondLength());
				  Thread.sleep(1000);
				//  clip.stop();
			  } 
			  	catch (Exception exo) {System.err.println(exo.getMessage());}
			}
			
		}
		
	}
	

	
	

	
	
}


