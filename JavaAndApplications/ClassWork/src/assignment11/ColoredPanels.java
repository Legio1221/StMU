package assignment11;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColoredPanels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame myWindow = new JFrame("Sample Window");
		myWindow.setLayout(null);
		
		JPanel p = new JPanel();
		myWindow.add(p);
		p.setLayout(null);
		p.setBackground(Color.BLUE);
		p.setSize(200,200);
		p.setLocation(50,50);
		
		JPanel p2 = new JPanel();
		myWindow.add(p2);
		p2.setLayout(null);
		p2.setBackground(Color.GREEN);
		p2.setSize(200,200);
		p2.setLocation(300,50);
		
		JPanel p3 = new JPanel();
		myWindow.add(p3);
		p3.setLayout(null);
		p3.setBackground(Color.RED);
		p3.setSize(200,200);
		p3.setLocation(550,50);
		
		
		
		myWindow.setSize(900, 360);
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
