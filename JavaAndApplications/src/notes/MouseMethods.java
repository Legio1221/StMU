package notes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseMethods extends JFrame {

	private JPanel panel;

	public MouseMethods() {

		setLayout(null);
		setSize(200, 200);

		panel = new JPanel();

		panel.setSize(100, 100);

		panel.setBackground(Color.RED);

		panel.addMouseListener(new Listener());

		add(panel);

		setTitle("Mouse methods");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

			System.out.println("The panel was clicked...");

		}

		public void mouseEntered(MouseEvent e) {

			System.out.println("The mouse entered the panel.");

		}

		public void mouseExited(MouseEvent e) {

			System.out.println("The mouse exited the panel.");

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

	}

	public static void main(String args[]) {

		new MouseMethods();

	}

}