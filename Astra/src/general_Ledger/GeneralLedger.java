package general_Ledger;

import javax.swing.JFrame;
//GUI

public class GeneralLedger extends JFrame{

	private final int WINDOW_WIDTH = 720;
	private final int WINDOW_HEIGHT = 500;
	
	public GeneralLedger(){
		super("JButton Challenge");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		
		//add(pane);
		
		pack();
		
		setVisible(true);
	}
	
	public void buildPanel(){
		
	}
}
