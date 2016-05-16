package notes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Converter extends JFrame{
	
	JPanel p;
	JRadioButton selectFahrenheit, selectCelsius;
	JLabel celsius, fahrenheit, cmdUser;
	JTextField cField, fField;
	String f = "Convert to fahrenheit";
	String c = "Convert to Celsius";

	public Converter(){
		setTitle("Temperature Conversion");
		setSize(720, 100);
		setLocation(500, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		pack();
		
		setVisible(true);
		
	}
	
	public void buildPanel(){
		
		JPanel p = new JPanel();
		JTextField cField = new JTextField(3);
		celsius = new JLabel("Convert to Celsius");
		fahrenheit = new JLabel("Convert to Fahrenheit");
		cmdUser = new JLabel("Enter a value of Fahrenheit");
		selectFahrenheit = new JRadioButton(fahrenheit, true);
		selectCelsius = new JRadioButton(celsius);
		
		selectFahrenheit.addActionListener(new ButtonListener());
		selectCelsius.addActionListener(new ButtonListener());
		
		add(p);
		
	}
	
	public class ButtonListener implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e){
			//if else logic
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converter convert = new Converter();
	}

}
