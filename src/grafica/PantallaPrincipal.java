package grafica;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;



public class PantallaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int nivelInicial = 0;
	public static int getNivelInicial() {
		return nivelInicial;
	}
	public static void setNivelInicial(int nivelInicial) {
		PantallaPrincipal.nivelInicial = nivelInicial;
	}


	public JButton btnJugar;


	public static void main(String[] args) {
		/*Juego juego = new Juego();
		Juego.setInstance(juego);
		Juego.getInstance().setNivel(1);
		Juego.getInstance().setVidas(3);
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(Juego.getInstance().getNivel());
		Juego.ralph.romper(Juego.getInstance().getNivel());*/
		
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


	public PantallaPrincipal() throws IOException { //Constructor pantalla principal
		setResizable(false);
		//this.setMinimumSize(new Dimension(590, 440)); 
		setTitle("Fixit Felix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 432);
		this.setLocationRelativeTo(null);
	
		contentPane = new JPanel(); //Creacion de un nuevo panel
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
				PantallaAyuda JframeAyuda = new PantallaAyuda(PantallaPrincipal.this);
				JframeAyuda.setVisible(true);
				setVisible(false); //Pone visible la pantalla ayuda y no visible la principal
			}
		});
		
		JLabel label_3 = new JLabel(""); //Creacion boton puntaje
		label_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPuntaje JframePuntaje = new PantallaPuntaje(PantallaPrincipal.this);
				JframePuntaje.setLocationRelativeTo(getContentPane());
				JframePuntaje.setVisible(true);
				setVisible(false); //Pone visible y saca la principal
			}
		});
		
		JLabel label = new JLabel(""); // Boton configuracion
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaConfiguracion JframeConfiguracion = new PantallaConfiguracion(PantallaPrincipal.this);
				JframeConfiguracion.setVisible(true);
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
}
