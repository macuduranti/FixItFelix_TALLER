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
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import test.JuegoMain;
import test.JuegoTask;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/JAmarillo.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/J.png")));
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoGrafica JframeJuego = new JuegoGrafica();
				JframeJuego.frame.setVisible(true);
				setVisible(false);
				
				//Esto es todo para el test, no deberia ser asi - NO DARLE BOLA
				/*JuegoMain juegomain = new JuegoMain();
				Timer timer = new Timer("Imprimir....");
				JuegoTask task = new JuegoTask();
				timer.schedule(task, 0, 10);*/
			}
		});
		button.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/J.png")));
		button.setBounds(217, 180, 184, 69);
		panel.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaAyuda JframeAyuda = new PantallaAyuda();
				JframeAyuda.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaPuntaje JframePuntaje = new PantallaPuntaje();
				JframePuntaje.setVisible(true);
				setVisible(false);
			}
		});
		label_3.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/trofeo_final.png")));
		label_3.setBounds(479, 336, 68, 63);
		panel.add(label_3);
		label_2.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/?_final.png")));
		label_2.setBounds(46, 336, 60, 60);
		panel.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/fondo_principal.png")));
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
