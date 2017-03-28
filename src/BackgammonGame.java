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



public class BackgammonGame {
	
	private final JPanel gui = new JPanel(new BorderLayout(3,3));
	private JButton[][] backgammonSquares = new JButton[8][8];
	private JPanel bgBoard;
	
	
	BackgammonGame(){
		initializeGui();
	}
	
	
	public final void initializeGui(){
		gui.setBorder(new EmptyBorder(5,5,5,5));
		JToolBar tools = new JToolBar();
		tools.setFloatable(true);
		tools.add(new JButton("New"));
		tools.add(new JButton("Restart"));
		
		
		bgBoard = new JPanel(new GridLayout());
		bgBoard.setBorder(new LineBorder(Color.BLACK));
		
		gui.add(tools, BorderLayout.NORTH);
		gui.add(bgBoard, BorderLayout.WEST);
		
		ImageIcon image = new ImageIcon("images/board.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		bgBoard.add( label, BorderLayout.WEST);
		
		
		
		
		
		
		
	}
	
	
	
	//public final JComponent getBoard(
		//return bgBoard;
			//)
	
	public final JComponent getGui(){
		return gui;
	}

	public static void main(String[] args)
	{
		Runnable r = new Runnable(){

			@Override
			public void run() {
				BackgammonGame bg = new BackgammonGame();
				
				JFrame frame = new JFrame("BackGammon");
				frame.add(bg.getGui());
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setLocationByPlatform(true);
				frame.setSize(1300,600);
				//frame.pack();
				frame.setMinimumSize(frame.getSize());
				frame.setVisible(true);
				// TODO Auto-generated method stub
				
			}
		};
		SwingUtilities.invokeLater(r);
			
			
			
		}
		
		
	
	}


