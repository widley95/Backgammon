
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.*;


public class BackgammonUI extends JPanel
{

	private JFrame boardFrame; 
	public JPanel gameboardPanel;

	ImageIcon iconBoard;
	
	public BackgammonUI()
	{
		initComponents();
	}
	
	private void initComponents()
	{
		boardFrame = new JFrame("Backgammon"); 
		boardFrame.setSize(1600, 850);
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.getContentPane().add(gameboardPanel, BorderLayout.CENTER);
		boardFrame.setVisible(true);
		
		//boardlayoutPanel();
		
		
		
		
		
	}

	private Image image = null;
	   public BackgammonUI(String filename) {
	        this.image = new ImageIcon(filename).getImage();
	    }

	     @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        //g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
	        g.drawImage(image, 0, 0,1100,756,null);
	    }
	
	/*public void boardlayoutPanel(){
		
		gameboardPanel = new BackgammonUI("images/boardpic.jpg");
		gameboardPanel.setMinimumSize(new Dimension(400,400));
		gameboardPanel.setPreferredSize(new Dimension(1300,400));
		//gameboardPanel.add(new JLabel(new ImageIcon("Images/boardpic.jpg")));  ADD THE BACKGROUND IMAGE 
		gameboardPanel.setBorder(BorderFactory.createTitledBorder("Backgammon Board"));
		boardFrame.add(gameboardPanel,BorderLayout.WEST);
		
		
		
		
	}*/
}

