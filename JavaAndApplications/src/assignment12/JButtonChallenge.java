package assignment12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonChallenge extends JFrame{
	
	private JPanel pane, scoreBox, scoreBox2;
	private JButton redScore, blueScore, resetScore;
	private JLabel redLabel, blueLabel, redPoint, bluePoint;
	private final int WINDOW_WIDTH = 720;
	private final int WINDOW_HEIGHT = 500;
	public String redNum = "0"; 
	public String blueNum = "0";
	
	public JButtonChallenge(){
		super("JButton Challenge");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		
		add(pane);
		
		pack();
		
		setVisible(true);
	}
	
	private void buildPanel(){
		//Set up 
		redScore = new JButton("Red Point!");
		
		
		blueScore = new JButton("Blue Point!");
		
		
		resetScore = new JButton("Reset Score");
		
		
		redLabel = new JLabel("Red Team");
		blueLabel = new JLabel("Blue Team");
		redPoint = new JLabel(redNum);
		bluePoint = new JLabel(blueNum);
		
		
		Font font = new Font("Serif", Font.BOLD, 18);
		
		redLabel.setFont(font);
		redLabel.setForeground(Color.RED);
		
		blueLabel.setFont(font);
		blueLabel.setForeground(Color.BLUE);
		
		scoreBox = new JPanel();
		scoreBox.setSize(400, 400);
		scoreBox.setLayout(new BoxLayout(scoreBox, BoxLayout.Y_AXIS));
		
		
		scoreBox2 = new JPanel();
		scoreBox2.setSize(400, 400);
		scoreBox2.setLayout(new BoxLayout(scoreBox2, BoxLayout.Y_AXIS));
		
		pane = new JPanel(new GridBagLayout());
		
		//Setup up the score counter and button that raises score
				scoreBox.add(redPoint);
				scoreBox.add(redScore);
				
				scoreBox2.add(bluePoint);
				scoreBox2.add(blueScore);
			
		
		GridBagConstraints c = new GridBagConstraints();
		
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = .5;
            c.gridx = 0;
            c.gridy = 0;
            pane.add(redLabel, c);
            
            c.gridx = 2;
            pane.add(blueLabel, c);
            
            c.gridy = 1;
            c.gridx = 0;
            c.ipady = 0;
            c.weighty = .5;
            pane.add(scoreBox, c);
            
            c.gridx = 2;
            pane.add(scoreBox2, c);
            
            c.gridy = 2;
            c.gridx = 0;
            c.gridwidth = 3;
            c.anchor = GridBagConstraints.PAGE_END;
            c.ipady = 0;
            c.weightx = 1;
            c.weighty = .3;
            c.fill = GridBagConstraints.BOTH;
            pane.add(resetScore, c);
            
       
            redScore.addActionListener(new RedScoreButton());
            blueScore.addActionListener(new BlueScoreButton());
            resetScore.addActionListener(new ResetScoreButton());
          
	}
	
	public class RedScoreButton implements ActionListener{
			int num=5;
		public void actionPerformed(ActionEvent e){
			
			
			
			num++;
			redNum = String.valueOf(num);
			
			
		}
	}
	
	public class BlueScoreButton implements ActionListener{
		int num=0;
		public void actionPerformed(ActionEvent e){
			
			
			
			num++;
			blueNum = String.valueOf(num);
			
			
		}
	}
	
	public class ResetScoreButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			redNum = String.valueOf(0);
			blueNum = String.valueOf(0);
			
		}
	}
	
	public static void main(String[] args){
		JButtonChallenge test = new JButtonChallenge();
	}
}
