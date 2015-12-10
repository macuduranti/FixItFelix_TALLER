package grafica;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class PantallaConfiguracion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> listaNivel;
	
	public PantallaConfiguracion(PantallaPrincipal pp) {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/res/fuente/VCR_OSD_MONO_1.001.ttf"));

			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(font);
			font = font.deriveFont(12f);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		this.setLocationRelativeTo(pp.getContentPane());
		this.setLocation((int)this.getLocation().getX() + 295, (int)this.getLocation().getY()-205);
		
		this.setSize( 290 , 210);
		JLabel lblElegir = new JLabel("Elegir Nivel");
		lblElegir.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegir.setFont(font.deriveFont(Font.PLAIN, 28f));
		lblElegir.setForeground(Color.WHITE);
		lblElegir.setBounds(0,0,290,40);
		getContentPane().add(lblElegir);
		
		String lvls[]={"NIVEL 1", "NIVEL 2", "NIVEL 3", "NIVEL 4", "NIVEL 5", "NIVEL 6", "NIVEL 7", "NIVEL 8", "NIVEL 9", "NIVEL 10"};
		listaNivel = new JList<String>(lvls);
		listaNivel.setFont(font);
		listaNivel.setForeground(Color.WHITE);
		listaNivel.setBackground(Color.BLACK);
		//listaNivel.setSelectionForeground(Color.BLACK);
		//listaNivel.setSelectionBackground(Color.YELLOW);
		this.setUndecorated(true);	
		JScrollPane scroll = new JScrollPane(listaNivel);
		scroll.setBounds(20, 48, 250, 70);
		scroll.setBackground(Color.DARK_GRAY);
		scroll.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.YELLOW ));
		getContentPane().add(scroll);
		
		JLabel lblAtras = new JLabel(""); //Boton atras
		lblAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblAtras.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
		lblAtras.setBounds(20, 130, 52, 52);
		getContentPane().add(lblAtras);
		
		JLabel lblAceptar = new JLabel(""); //Boton aceptar
		lblAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.setNivelInicial(listaNivel.getSelectedIndex()+1);
				System.out.println(listaNivel.getSelectedIndex()+1);
				setVisible(false);
			}
		});
		lblAceptar.setIcon(new ImageIcon(PantallaAyuda.class.getResource("/res/flecha_final.png")));
		lblAceptar.setBounds(218, 130, 52, 52);
		getContentPane().add(lblAceptar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PantallaConfiguracion.class.getResource("/res/fondo puntaje.jpg")));
		lblFondo.setBounds(-60, 0, 350, 433);
		getContentPane().add(lblFondo);
	}
}
