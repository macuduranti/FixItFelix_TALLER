package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;

import juego.Juego;

public class CambioSeccion extends JFrame {

	private JPanel contentPane;
	private int sec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int sec = Juego.getInstance().getSeccion();
					CambioSeccion frame = new CambioSeccion();
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
	public CambioSeccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Font font = null;
		
			try {
				font = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/res/fuente/VCR_OSD_MONO_1.001.ttf"));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(font);
			font = font.deriveFont(12f);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/bienFelixGif.gif")));
		lblNewLabel_2.setBounds(148, 38, 498, 177);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("¡SECCION " + sec + "!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 50f));
		lblNewLabel_1.setBounds(135, 179, 480, 177);
		getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/FondoNegro.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 590, 410);
		contentPane.add(lblNewLabel);
	}
	
}

