package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class PantallaPuntaje extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPuntaje frame = new PantallaPuntaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPuntaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/flecha.png")));
		button.setBounds(344, 232, 235, 185);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaPuntaje.class.getResource("/res/fondo puntaje.jpg")));
		label.setBounds(6, 0, 654, 417);
		contentPane.add(label);
	}

}
