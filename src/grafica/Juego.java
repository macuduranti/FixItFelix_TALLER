package grafica;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import juego.Niceland;

public class Juego {
	private int desp = 0;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

		JLabel lblPrimerPiso = new JLabel("");
		lblPrimerPiso.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[2][1].getSprite())));
		lblPrimerPiso.setBounds(195, 257 + desp, 62, 56);
		panel.add(lblPrimerPiso);

		JLabel lblPlantaBaja = new JLabel(" ");
		lblPlantaBaja.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[2][0].getSprite())));
		lblPlantaBaja.setBounds(195, 313 + desp, 61, 97);
		panel.add(lblPlantaBaja);

		JLabel lblVentana3 = new JLabel("");
		lblVentana3.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[0][2].getSprite())));
		lblVentana3.setBounds(105, 176 + desp, 38, 60);
		panel.add(lblVentana3);
		JLabel lblVentana4 = new JLabel("");
		lblVentana4.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[1][2].getSprite())));
		lblVentana4.setBounds(150, 176 + desp, 38, 60);
		panel.add(lblVentana4);

		JLabel lblVentana = new JLabel("");
		lblVentana.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[2][2].getSprite())));
		lblVentana.setBounds(205, 176 + desp, 38, 60);
		panel.add(lblVentana);

		JLabel lblVentana1 = new JLabel("");
		lblVentana1.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[3][2].getSprite())));
		lblVentana1.setBounds(260, 176 + desp, 38, 60);
		panel.add(lblVentana1);
		JLabel lblVentana2 = new JLabel("");
		lblVentana2.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[4][2].getSprite())));
		lblVentana2.setBounds(305, 176 + desp, 38, 60);
		panel.add(lblVentana2);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JLabel lblVentanaW = new JLabel("");
				lblVentanaW.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[j+(i*3)+2][0].getSprite())));
				lblVentanaW.setBounds(105, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaW);
				JLabel lblVentanaWM = new JLabel("");
				lblVentanaWM.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[j+(i*3)+2][1].getSprite())));
				lblVentanaWM.setBounds(150, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaWM);

				JLabel lblVentanaM = new JLabel("");
				lblVentanaM.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[j+(i*3)+2][2].getSprite())));
				lblVentanaM.setBounds(205, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaM);

				JLabel lblVentanaEM = new JLabel("");
				lblVentanaEM.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[j+(i*3)+2][3].getSprite())));
				lblVentanaEM.setBounds(260, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaEM);
				JLabel lblVentanaE = new JLabel("");
				lblVentanaE.setIcon(new ImageIcon(Juego.class.getResource(Niceland.getInstance().edificio[j+(i*3)+2][4].getSprite())));
				lblVentanaE.setBounds(305, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaE);
			}
		}
		
		JLabel lblNiceland = new JLabel("");
		lblNiceland.setIcon(new ImageIcon(Juego.class.getResource("/res/niceland/edificio_150.png")));
		lblNiceland.setBounds(65, -619 + desp, 315, 1028);
		panel.add(lblNiceland);

	}
}
