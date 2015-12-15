package grafica;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;



public class PantallaPrincipal extends JFrame {

	/**
	 * 
	 */
	public PantallaAyuda pAyuda;
	public PantallaPuntaje pPuntajes;
	public PantallaConfiguracion pConfiguracion;
	
	
	
	public static PantallaPrincipal instance;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int nivelInicial = 1;
	public static int getNivelInicial() {
		return nivelInicial;
	}
	public static void setNivelInicial(int nivelInicial) {
		PantallaPrincipal.nivelInicial = nivelInicial;
	}


	public JButton btnJugar;

	public PantallaPrincipal() throws IOException { //Constructor pantalla principal
		PantallaPrincipal.setInstance(this);
		setResizable(false);
		this.setpAyuda(new PantallaAyuda());
		this.setpConfiguracion(new PantallaConfiguracion());
		this.setpPuntajes(new PantallaPuntaje());
		setTitle("Fixit Felix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		this.setLocationRelativeTo(null);
	
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -18, 2618, 1326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		btnJugar = new JButton(""); //Creacion del boton JUGAR
		btnJugar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnJugar.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/JAmarillo.png")));
			}
			public void mouseExited(MouseEvent e) {
				btnJugar.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/J.png"))); //Animacion que cambia entre amarillo y negro
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		btnJugar.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/J.png")));
		btnJugar.setBounds(217, 180, 184, 69);
		panel.add(btnJugar);
		
		JLabel label_2 = new JLabel(""); //Creacion boton ayuda
		label_2.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.this.getpAyuda().setVisible(true);
				setVisible(false); //Pone visible la pantalla ayuda y no visible la principal
			}
		});
		
		JLabel label_3 = new JLabel(""); //Creacion boton puntaje
		label_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.this.getpPuntajes().setVisible(true);
				setVisible(false); //Pone visible y saca la principal
			}
		});
		
		JLabel label = new JLabel(""); // Boton configuracion
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.this.getpConfiguracion().setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/configuracion.png")));
		label.setBounds(482, 40, 68, 75);
		panel.add(label);
		
		label_3.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/trofeo_final.png")));
		label_3.setBounds(479, 336, 68, 63);
		panel.add(label_3);
		
		label_2.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/pregunta_final.png")));
		label_2.setBounds(46, 336, 60, 60);
		panel.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/res/fondo_principal.png")));
		label_1.setBounds(6, 18, 590, 417);
		panel.add(label_1);
	}
	public static PantallaPrincipal getInstance() {
		return instance;
	}
	public static void setInstance(PantallaPrincipal instance) {
		PantallaPrincipal.instance = instance;
	}
	public PantallaAyuda getpAyuda() {
		return pAyuda;
	}
	public void setpAyuda(PantallaAyuda pAyuda) {
		this.pAyuda = pAyuda;
	}
	public PantallaPuntaje getpPuntajes() {
		return pPuntajes;
	}
	public void setpPuntajes(PantallaPuntaje pPuntajes) {
		this.pPuntajes = pPuntajes;
	}
	public PantallaConfiguracion getpConfiguracion() {
		return pConfiguracion;
	}
	public void setpConfiguracion(PantallaConfiguracion pConfiguracion) {
		this.pConfiguracion = pConfiguracion;
	}
}
