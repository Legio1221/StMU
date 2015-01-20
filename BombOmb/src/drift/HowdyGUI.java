package drift;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HowdyGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowdyGUI window = new HowdyGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HowdyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 367, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblString = new JLabel("String");
		lblString.setBounds(21, 26, 46, 14);
		frame.getContentPane().add(lblString);
		
		JLabel lblRepitionAmt = new JLabel("Repition Amt:");
		lblRepitionAmt.setBounds(21, 50, 65, 14);
		frame.getContentPane().add(lblRepitionAmt);
		
		textField = new JTextField();
		textField.setBounds(94, 23, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 47, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFileLocation = new JLabel("File Location");
		lblFileLocation.setBounds(21, 75, 65, 14);
		frame.getContentPane().add(lblFileLocation);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 72, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
