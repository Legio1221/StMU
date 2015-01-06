package pseudoLedger;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

public class MyGenLedApp {

	private JFrame frame;
	private JTextField coaTextField;
	private JTextField amountTextField;
	private JTextField docCodeTextField;
	private JLabel bankLabel;
	private JTextField bankTextField;
	private JButton nextButton;
	private JButton btnFinish;
	private JLabel lblAdvantageInterpreter;
	private JTextField txtChecksDate;
	private CheckRegister ckReg;
	private JLabel DescriptionLabel;
	private JTextField txtDescription;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGenLedApp window = new MyGenLedApp();
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
	public MyGenLedApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1020, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setBounds(46, 116, 100, 42);
		frame.getContentPane().add(dateLabel);
		
		JLabel coaLabel = new JLabel("CoA");
		coaLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		coaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		coaLabel.setBounds(46, 174, 69, 20);
		frame.getContentPane().add(coaLabel);
		
		coaTextField = new JTextField();
		coaTextField.setToolTipText("Due to the nature of this program, the user must be well aquainted with ADV's CoAs.");
		coaTextField.setText("Chart of Account Number");
		coaTextField.setColumns(10);
		coaTextField.setBounds(178, 169, 358, 33);
		frame.getContentPane().add(coaTextField);
		
		amountTextField = new JTextField();
		amountTextField.setToolTipText("Amount on check or sub-amount.");
		amountTextField.setText("Amount");
		amountTextField.setColumns(10);
		amountTextField.setBounds(178, 219, 358, 33);
		frame.getContentPane().add(amountTextField);
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		amountLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		amountLabel.setBounds(46, 224, 100, 20);
		frame.getContentPane().add(amountLabel);
		
		JLabel lblDocCode = new JLabel("Doc. Code");
		lblDocCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocCode.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDocCode.setBounds(46, 281, 120, 20);
		frame.getContentPane().add(lblDocCode);
		
		docCodeTextField = new JTextField();
		docCodeTextField.setToolTipText("Check Number");
		docCodeTextField.setText("Document Code");
		docCodeTextField.setColumns(10);
		docCodeTextField.setBounds(178, 268, 358, 33);
		frame.getContentPane().add(docCodeTextField);
		
		bankLabel = new JLabel("Bank CoA");
		bankLabel.setHorizontalAlignment(SwingConstants.LEFT);
		bankLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		bankLabel.setBounds(46, 332, 120, 20);
		frame.getContentPane().add(bankLabel);
		
		bankTextField = new JTextField();
		bankTextField.setToolTipText("CoA usually 1100120. Around that range.");
		bankTextField.setText("Bank Chart of Account");
		bankTextField.setBounds(178, 323, 358, 33);
		frame.getContentPane().add(bankTextField);
		bankTextField.setColumns(10);
		
		nextButton = new JButton("Next");
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				 * 
				 * txtChecksDate
				 * coaTextField
				 * docCodeTextField
				 * bankTextField
				 * amountTextField
				 */
				int amount = Integer.parseInt(amountTextField.getText());
				int docCode = Integer.parseInt(coaTextField.getText());
				int coa = Integer.parseInt(coaTextField.getText());
				int bankCoa = Integer.parseInt(bankTextField.getText());
				Date date = Date.valueOf(txtChecksDate.getText());
				//Set up method with String instead of char[].
				//ckReg.addCheck(date, coa, amount, bankCoa, txtDescription.getText());
				
			}
		});
		nextButton.setBounds(347, 482, 200, 50);
		frame.getContentPane().add(nextButton);
		
		btnFinish = new JButton("Finish");
		btnFinish.setBounds(688, 523, 200, 50);
		frame.getContentPane().add(btnFinish);
		
		lblAdvantageInterpreter = new JLabel("Advantage Interpreter");
		lblAdvantageInterpreter.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAdvantageInterpreter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvantageInterpreter.setBounds(161, 28, 680, 67);
		frame.getContentPane().add(lblAdvantageInterpreter);
		
		txtChecksDate = new JTextField();
		txtChecksDate.setText("Check's Date");
		txtChecksDate.setBounds(178, 118, 355, 33);
		frame.getContentPane().add(txtChecksDate);
		txtChecksDate.setColumns(10);
		
		DescriptionLabel = new JLabel("Description");
		DescriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DescriptionLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		DescriptionLabel.setBounds(46, 387, 120, 20);
		frame.getContentPane().add(DescriptionLabel);
		
		txtDescription = new JTextField();
		txtDescription.setToolTipText("25 Character Limit!");
		txtDescription.setText("Description");
		txtDescription.setColumns(10);
		txtDescription.setBounds(178, 374, 358, 33);
		frame.getContentPane().add(txtDescription);
	}
}
