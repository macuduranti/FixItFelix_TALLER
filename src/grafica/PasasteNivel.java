package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PasasteNivel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasasteNivel frame = new PasasteNivel();
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
	public PasasteNivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		
		
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
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/bienFelixGif.gif")));
		lblNewLabel_2.setBounds(148, 38, 498, 177);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("¡PASASTE DE NIVEL!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 45f));
		lblNewLabel_1.setBounds(68, 172, 480, 177);
		getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/FondoNegro.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 590, 410);
		contentPane.add(lblNewLabel);
		
		
		
		
	}

}
