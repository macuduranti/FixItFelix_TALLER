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
import javax.swing.JTextField;

public class PantallaGameOver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGameOver frame = new PantallaGameOver();
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
	public PantallaGameOver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JLabel lblNewLabel_1 = new JLabel("Game Over...");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(font.deriveFont(Font.PLAIN, 50f));
		lblNewLabel_1.setBounds(128, 39, 480, 177);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(176, 203, 230, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel(""); //Boton atras
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal JframePrincipal;
				try {
					JframePrincipal = new PantallaPrincipal();
					JframePrincipal.setVisible(true);
					setVisible(false);
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		label_1.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
		label_1.setBounds(54, 303, 52, 52);
		contentPane.add(label_1);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CambioSeccion.class.getResource("/res/FondoNegro.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 608, 410);
		contentPane.add(lblNewLabel);
		
		JLabel label_11 = new JLabel(""); //Boton atras
		label_11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal JframePrincipal;
				try {
					JframePrincipal = new PantallaPrincipal();
					JframePrincipal.setVisible(true);
					setVisible(false);
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
}
