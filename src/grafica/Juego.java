package grafica;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import juego.Niceland;
import ventana.ConHojas;
import ventana.DosPaneles;
import ventana.PlantaBaja;
import ventana.PrimerPiso;
import ventana.Ventana;

public class Juego {
	public final ImageIcon pngConHojasAbierta = new ImageIcon(Juego.class.getResource("/res/niceland/slice106_@.png"));
	public final ImageIcon pngConHojasCerrada = new ImageIcon(Juego.class.getResource("/res/niceland/slice105_@.png"));
	public final ImageIcon pngDosPaneles = new ImageIcon(Juego.class.getResource("/res/niceland/slice103_@.png"));
	public final ImageIcon pngPlantaBaja = new ImageIcon(Juego.class.getResource("/res/niceland/slice600_@.png"));
	public final ImageIcon pngPrimerPiso = new ImageIcon(Juego.class.getResource("/res/niceland/slice602_@.png"));
	
	private int desp = 0;

	public int getDesp() {
		return desp;
	}

	public void setDesp(int desp) {
		this.desp = desp;
	}

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(3);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego window = new Juego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Juego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblAcaVaEl = new JLabel("Aca va el puntaje las vidas etc");
		frame.getContentPane().add(lblAcaVaEl, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		/*
		 * 
		 * Hay que cambiar la imagen de la con hojas abierta para que se abra
		 * solo hacia la izquierda
		 * 
		 * Faltan los paneles
		 * 
		 */

		// Ventanas Planta Baja
		JLabel lblVentana00 = new JLabel("");
		lblVentana00.setBounds(105, 330 + desp, 38, 60);
		lblVentana00
				.setIcon(definirSprite(Niceland.getInstance().edificio[0][0]));
		panel.add(lblVentana00);

		JLabel lblVentana10 = new JLabel("");
		lblVentana10
				.setIcon(definirSprite(Niceland.getInstance().edificio[1][0]));
		lblVentana10.setBounds(150, 330 + desp, 38, 60);
		panel.add(lblVentana10);

		JLabel lblPlantaBaja = new JLabel(" ");
		lblPlantaBaja.setIcon(definirSprite(Niceland.getInstance().edificio[2][0]));
		lblPlantaBaja.setBounds(195, 313 + desp, 61, 97);
		panel.add(lblPlantaBaja);

		JLabel lblVentana30 = new JLabel("");
		lblVentana30
				.setIcon(definirSprite(Niceland.getInstance().edificio[3][0]));
		lblVentana30.setBounds(260, 330 + desp, 38, 60);
		panel.add(lblVentana30);

		JLabel lblVentana40 = new JLabel("");
		lblVentana40
				.setIcon(definirSprite(Niceland.getInstance().edificio[4][0]));
		lblVentana40.setBounds(305, 330 + desp, 38, 60);
		panel.add(lblVentana40);
		//

		// Ventanas Primer Piso
		JLabel lblVentana01 = new JLabel("");
		lblVentana01
				.setIcon(definirSprite(Niceland.getInstance().edificio[0][1]));
		lblVentana01.setBounds(105, 257 + desp, 38, 60);
		panel.add(lblVentana01);

		JLabel lblVentana11 = new JLabel("");
		lblVentana11
				.setIcon(definirSprite(Niceland.getInstance().edificio[1][1]));
		lblVentana11.setBounds(150, 257 + desp, 38, 60);
		panel.add(lblVentana11);

		JLabel lblPrimerPiso = new JLabel("");
		lblPrimerPiso.setIcon(definirSprite(Niceland.getInstance().edificio[2][1]));
		lblPrimerPiso.setBounds(195, 257 + desp, 62, 56);
		panel.add(lblPrimerPiso);

		JLabel lblVentana31 = new JLabel("");
		lblVentana31
				.setIcon(definirSprite(Niceland.getInstance().edificio[3][1]));
		lblVentana31.setBounds(260, 257 + desp, 38, 60);
		panel.add(lblVentana31);

		JLabel lblVentana41 = new JLabel("");
		lblVentana41
				.setIcon(definirSprite(Niceland.getInstance().edificio[4][1]));
		lblVentana41.setBounds(305, 257 + desp, 38, 60);
		panel.add(lblVentana41);
		//

		// Ventanas Segundo Piso
		JLabel lblVentana02 = new JLabel("");
		lblVentana02
				.setIcon(definirSprite(Niceland.getInstance().edificio[0][2]));
		lblVentana02.setBounds(105, 176 + desp, 38, 60);
		panel.add(lblVentana02);

		JLabel lblVentana12 = new JLabel("");
		lblVentana12
				.setIcon(definirSprite(Niceland.getInstance().edificio[1][2]));
		lblVentana12.setBounds(150, 176 + desp, 38, 60);
		panel.add(lblVentana12);

		JLabel lblVentana22 = new JLabel("");
		lblVentana22
				.setIcon(definirSprite(Niceland.getInstance().edificio[2][2]));
		lblVentana22.setBounds(205, 176 + desp, 38, 60);
		panel.add(lblVentana22);

		JLabel lblVentana32 = new JLabel("");
		lblVentana32
				.setIcon(definirSprite(Niceland.getInstance().edificio[3][2]));
		lblVentana32.setBounds(260, 176 + desp, 38, 60);
		panel.add(lblVentana32);

		JLabel lblVentana42 = new JLabel("");
		lblVentana42
				.setIcon(definirSprite(Niceland.getInstance().edificio[4][2]));
		lblVentana42.setBounds(305, 176 + desp, 38, 60);
		panel.add(lblVentana42);
		//
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JLabel lblVentanaW = new JLabel("");
				lblVentanaW.setIcon(definirSprite(Niceland.getInstance().edificio[0][j + (i * 3) + 2]));
				lblVentanaW.setBounds(105, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaW);
				JLabel lblVentanaWM = new JLabel("");
				lblVentanaWM.setIcon(definirSprite(Niceland.getInstance().edificio[1][j + (i * 3) + 2]));
				lblVentanaWM.setBounds(150, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaWM);

				JLabel lblVentanaM = new JLabel("");
				lblVentanaM.setIcon(definirSprite(Niceland.getInstance().edificio[2][j + (i * 3) + 2]));
				lblVentanaM.setBounds(205, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaM);

				JLabel lblVentanaEM = new JLabel("");
				lblVentanaEM.setIcon(definirSprite(Niceland.getInstance().edificio[3][j + (i * 3) + 2]));
				lblVentanaEM.setBounds(260, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaEM);
				JLabel lblVentanaE = new JLabel("");
				lblVentanaE.setIcon(definirSprite(Niceland.getInstance().edificio[4][j + (i * 3) + 2]));
				lblVentanaE.setBounds(305, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaE);
			}
		}

		JLabel lblNiceland = new JLabel("");
		lblNiceland.setIcon(new ImageIcon(Juego.class.getResource("/res/niceland/edificio_150.png")));
		lblNiceland.setBounds(65, -619 + desp, 315, 1028);
		panel.add(lblNiceland);
	}
	
	private ImageIcon definirSprite(Ventana ventana) {		
		if (ventana instanceof ConHojas) {
			if (((ConHojas) ventana).isAbierta())
				return this.pngConHojasAbierta;
			else
				return this.pngConHojasCerrada;
		} else if (ventana instanceof DosPaneles)
			return this.pngDosPaneles;
		else if (ventana instanceof PlantaBaja)
			return this.pngPlantaBaja;
		else if (ventana instanceof PrimerPiso)
			return this.pngPrimerPiso;
		return null;
	}
}
