import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class BackgammonGame {
	

	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	BackgammonGame(){
		initializeGui();
	}
	
	
	public final static void initializeGui(){
		

		JFrame frame = new JFrame("BackGammon");
		frame.getContentPane();
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(new Color(230, 230, 250));
		
		JPanel buttonPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 1025, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(boardPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 522, Short.MAX_VALUE)
						.addComponent(buttonPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		
		
		JLabel boardLabel = new JLabel("");
		boardLabel.setIcon(new ImageIcon(BackgammonGame.class.getResource("/Images/boardo.jpg")));
		boardLabel.setOpaque(false);
		boardLabel.repaint();
		
		JLabel introString = new JLabel("WELCOME TO BACKGAMMON");
		introString.setBackground(Color.GREEN);
		introString.setForeground(Color.RED);
		introString.setFont(new Font("Lucida Calligraphy", Font.BOLD, 31));
		
		GroupLayout gl_boardPanel = new GroupLayout(boardPanel);
		gl_boardPanel.setHorizontalGroup(
			gl_boardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_boardPanel.createSequentialGroup()
					.addGap(206)
					.addComponent(introString)
					.addContainerGap(239, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_boardPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(boardLabel)
					.addContainerGap())
		);
		gl_boardPanel.setVerticalGroup(
			gl_boardPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_boardPanel.createSequentialGroup()
					.addComponent(boardLabel)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(introString)
					.addGap(230))
		);
		boardPanel.setLayout(gl_boardPanel);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		Button singleButton = new Button("Single Player");
		singleButton.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		buttonPanel.add(singleButton);
		
		Button multiButton = new Button("Multiplayer ");
		multiButton.setFont(new Font("Book Antiqua", Font.BOLD, 22));
		buttonPanel.add(multiButton);
		frame.getContentPane().setLayout(groupLayout);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setSize(1300,600);
		
		//frame.pack();
		frame.setMinimumSize(frame.getSize());
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mnFile.add(mntmReset);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		frame.setVisible(true);

	
		
		
	}
	
	
	
	//public final JComponent getBoard(
		//return bgBoard;
			//)
	
	
	public static void main(String[] args)
	{
		Runnable r = new Runnable(){

			@Override
			public void run() {
				initializeGui();
				
			}
		};
		SwingUtilities.invokeLater(r);
			
			
			
		}
	
	}


