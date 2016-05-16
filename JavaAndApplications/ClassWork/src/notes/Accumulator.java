package notes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Accumulator extends JFrame{
	final int WINDOW_WIDTH = 720;
	final int WINDOW_HEIGHT = 500;
	private JPanel panel;
	private JLabel enterSum, accumulatedSum;
	private JTextField enterField, displayField;
	public int sum;

	
	public Accumulator(){
		super("Accumulator");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		add(panel);
		
		pack();
		
		setVisible(true);
	}
	
	public void buildPanel(){
		enterSum = new JLabel("Enter an Integer");
		accumulatedSum = new JLabel("The Accumulated Sum is:");
		enterField = new JTextField();
		displayField = new JTextField();
		
		displayField.setEditable(false);
		
		panel = new JPanel(new GridLayout(2,2,20,20));
		
		panel.add(enterSum);
		panel.add(enterField);
		panel.add(accumulatedSum);
		panel.add(displayField);

		enterField.addActionListener(new ButtonListener());
		
		
	}
	
	public class ButtonListener implements ActionListener{
		
		double num2 = 0;

		public void actionPerformed(ActionEvent e){
			String str; //Holds text entered
			double num;
			
			
			str = enterField.getText();
			
			num = Double.parseDouble(str);
			
			num2 = num + num2;
			
			displayField.setText(String.valueOf(num2));

			enterField.setText("");
			
			
		}
	}
	
	public static void main(String[] args){
		new Accumulator();
	}
}
