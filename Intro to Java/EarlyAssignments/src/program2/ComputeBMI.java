package program2;
import javax.swing.JOptionPane;

public class ComputeBMI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String pound;
double kilo;
double weight;
String inches;
double meter;
double height;

	pound = JOptionPane.showInputDialog("Enter your weight in pounds.");
	weight = Double.parseDouble(pound);
	kilo = weight * .45359237;
	
	inches = JOptionPane.showInputDialog("Enter your height in inches.");
	height = Double.parseDouble(inches);
	meter = height * .0254;
	
	JOptionPane.showMessageDialog(null,"Your Body Mass Index is " + kilo/meter);
	}

}
