package grafica;

import java.awt.*;

import javax.swing.*;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public PantallaPrincipal() throws IOException {
		setResizable(false);
		this.setMinimumSize(new Dimension(590, 440)); 
		setTitle("Fixit Felix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -18, 2618, 1326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("/Users/Santi/Desktop/FixItFelix_TALLER/images/estrella ladrillo.png"));
		button_1.setBounds(484, 341, 63, 65);
		panel.add(button_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("/Users/Santi/Desktop/FixItFelix_TALLER/images/JUGAR.png"));
		button.setBounds(224, 166, 177, 109);
		panel.add(button);
<<<<<<< Updated upstream
		button.setIcon(new ImageIcon("src/res/star-icon (1).png"));
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("src/res/sign-question-icon.png"));
		button_1.setBounds(61, 323, 80, 76);
		panel.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/res/background.png"));
=======
		
		JButton button_2 = new JButton("");
		button_2.setAction(action);
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(Color.BLACK);
		button_2.setIcon(new ImageIcon("/Users/Santi/Desktop/FixItFelix_TALLER/images/whats ladrillo copia.png"));
		button_2.setBounds(41, 341, 63, 65);
		panel.add(button_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/Santi/Desktop/FixItFelix_TALLER/images/pared22 copia.png"));
>>>>>>> Stashed changes
		label.setBounds(6, 18, 590, 419);
		panel.add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
			
			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
