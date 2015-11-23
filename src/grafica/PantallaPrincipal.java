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
import java.awt.Window.Type;

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
		setBounds(100, 100, 590, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -18, 2618, 1326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/res/background.png"));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/JUGAR.png")));
		button.setBounds(217, 180, 177, 69);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAyuda JframeAyuda = new PantallaAyuda();
				JframeAyuda.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/?.jpg")));
		button_1.setBounds(55, 345, 59, 53);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaPuntaje JframePuntaje = new PantallaPuntaje();
				JframePuntaje.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/trofeo.jpg")));
		button_2.setBounds(504, 336, 52, 62);
		panel.add(button_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/fondo principal.png")));
		label_1.setBounds(6, 18, 590, 417);
		panel.add(label_1);
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
