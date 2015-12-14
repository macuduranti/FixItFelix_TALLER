package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JTextField;

import juego.Juego;

public class PantallaGameOver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;

	/**
	 * Create the frame.
	 */
	public PantallaGameOver(boolean record, JuegoGrafica jg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(jg.frame);
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass()
					.getResourceAsStream("/res/fuente/VCR_OSD_MONO_1.001.ttf"));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GraphicsEnvironment genv = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		genv.registerFont(font);
		font = font.deriveFont(12f);
		contentPane.setLayout(null);

		if (record) {

			JLabel lblNewLabel_1 = new JLabel("¡FELICITACIONES!");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 50f));
			lblNewLabel_1.setBounds(59, 50, 480, 177);
			getContentPane().add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(148, 214, 230, 38);
			contentPane.add(textField);
			textField.setColumns(10);

			JLabel label_1 = new JLabel(""); // BOTON PUNTAJE Y ORDENA LISTA
			label_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) { 
					try {
						Controller.getInstance().ActualizarLista(textField.getText(), Juego.getInstance().getPuntosJugadorActual());
						PantallaPrincipal.getInstance().setLocationRelativeTo(PantallaGameOver.this);
						setVisible(false);
						PantallaPrincipal.getInstance().setVisible(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_adelante.png")));
			label_1.setBounds(390, 197, 52, 69);
			contentPane.add(label_1);

		}
		
	
		
			
		if (!record) {
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(PantallaGameOver.class.getResource("/res/flecha_final.png")));
			label.setBounds(25, 30, 61, 52);
			contentPane.add(label);
			
			JLabel lblNewLabel_1 = new JLabel("GAME OVER");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 50f));
			lblNewLabel_1.setBounds(59, 70, 480, 177);
			getContentPane().add(lblNewLabel_1);
			
		}
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/fondo puntaje.jpg")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 590, 438);
		contentPane.add(lblNewLabel);

	}
}
