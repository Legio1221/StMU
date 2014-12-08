package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JFrame{
	final int WINDOW_WIDTH = 720;
	final int WINDOW_HEIGHT = 500;
	private JPanel panel;
	private JLabel label;
	private JTextField text;
	private JButton button;
	
	public Test(){
		super("Test");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		add(panel);
		
		pack();
		
		setVisible(true);
	}
	
	public void buildPanel(){
		
	}
	
	public class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
