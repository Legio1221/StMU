package assignment12;

import java.awt.*;

import javax.swing.*;

public class LabelAndFonts extends JFrame{
	
	JPanel panel, p2, p3;
	JPanel largePanel;
	JLabel label, label2, label3;
	JTextField textfield;
	
	public LabelAndFonts(){
		super("Labels and Fonts");
		
		setSize(900,360);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		buildPanel();
		
		add(largePanel);
				
		setVisible(true);
		
		
		
	}
	
	public void buildPanel(){
		largePanel = new JPanel(null);
		panel = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		
		largePanel.setSize(890, 350);
		
		label = new JLabel("Red");
		label2 = new JLabel("Blue");
		label3 = new JLabel("Yellow");
		
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		panel.setSize(200,200);
		panel.setLocation(50,50);
		
		p2.setLayout(null);
		p2.setBackground(Color.BLUE);
		p2.setSize(200,200);
		p2.setLocation(300,50);
		
		p3.setLayout(null);
		p3.setBackground(Color.YELLOW);
		p3.setSize(200,200);
		p3.setLocation(550,50);
		
		Font font = new Font("Serif", Font.BOLD, 18);
		label.setFont(font);
		label2.setFont(font);
		label3.setFont(font);
		
		label.setLocation(150, 35);
		label2.setLocation(400, 35);
		label3.setLocation(650, 35);
		
		label.setSize(65, 15);
		label2.setSize(65, 15);
		label3.setSize(65,15);
		
		label.setForeground(Color.RED);
		label2.setForeground(Color.BLUE);
		label3.setForeground(Color.YELLOW);
		
		largePanel.add(label);
		largePanel.add(label2);
		largePanel.add(label3);
		largePanel.add(panel);
		largePanel.add(p3);
		largePanel.add(p2);
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LabelAndFonts exe = new LabelAndFonts();
		
	}

}
