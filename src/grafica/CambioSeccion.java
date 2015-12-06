package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import juego.Juego;
import javax.swing.SwingConstants;

public class CambioSeccion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//int sec = Juego.getInstance().getSeccion();
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
		setBounds(100, 100, 200, 100);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createMatteBorder( 5, 5, 5, 5, Color.YELLOW ));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
	    this.setUndecorated(true);
		
		
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
		/*
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/bienFelixGif.gif")));
		lblNewLabel_2.setBounds(148, 38, 498, 177);
		contentPane.add(lblNewLabel_2);*/
		
		JLabel lblNewLabel_1 = new JLabel("¡SECCION " + (Juego.getInstance().getSeccion()+1) + "!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 22f));
		lblNewLabel_1.setBounds(0, 0, 200, 100);
		getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/FondoNegro.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(5, 5, 190, 90);
		contentPane.add(lblNewLabel);
	}
	
}


