package notes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Beeper extends JFrame{
	
	JButton j;

	public Beeper(){
		
		setTitle("Beeper Window");
		setSize(300,100);
		setLocation(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
	}
	
	public void buildPanel(){
		JButton j = new JButton("OK");
		add(j);
		j.addActionListener(new ButtonListener());
	}
	
	public class ButtonListener implements ActionListener{
		int clickCount = 0;
		
		public void actionPerformed(ActionEvent e){
			clickCount++;
			Toolkit.getDefaultToolkit().beep();
			System.out.println("You clicked " + clickCount + " times.");
			j.setText(String.valueOf(clickCount));
		}
	}

	public static void main(String[] args){
		Beeper b = new Beeper();
	}
}
