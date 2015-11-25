package grafica;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import juego.Juego;
import juego.Niceland;
import personajes.ralph.Ralph;
import ventana.ConHojas;
import ventana.DosPaneles;
import ventana.PlantaBaja;
import ventana.PrimerPiso;
import ventana.Ventana;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.SwingConstants;

public class JuegoGrafica {
	public final ImageIcon pngVidaFelix = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/vida-felix-small.png"));
	
	public final ImageIcon pngConHojasAbierta = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice106_@.png"));
	public final ImageIcon pngConHojasCerrada = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice105_@.png"));
	public final ImageIcon pngDosPaneles = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice103_@.png"));
	public final ImageIcon pngPlantaBaja = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice600_@.png"));
	public final ImageIcon pngPrimerPiso = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice602_@.png"));

	public final ImageIcon pngPanelParc1 = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/2p_panel_semi1.png"));
	public final ImageIcon pngPanelParc2 = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/2p_panel_semi2.png"));
	public final ImageIcon pngPanelSano = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/2p_panel_sano.png"));

	public final ImageIcon pngPanelP1Parc1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/p1_panel_semi1.png"));
	public final ImageIcon pngPanelP1Parc2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/p1_panel_semi2.png"));
	public final ImageIcon pngPanelP1Roto = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/p1_panel_roto.png"));
	
	public final ImageIcon pngPanelPBParc1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/pb_panel_semi1.png"));
	public final ImageIcon pngPanelPBParc2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/pb_panel_semi2.png"));
	public final ImageIcon pngPanelPBSano = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/pb_panel_sano.png"));

	public final ImageIcon pngMacetero = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/macetero.png"));
	public final ImageIcon pngMoldura = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice22_22.png"));

	private int desp = 715;

	// Seccion 0 = desp 0
	// Seccion 1 = desp 245
	// Seccion 2 = desp 480
	// Seccion 3 = desp 715
	
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
		Juego juego = new Juego();
		Juego.setInstance(juego);
		Juego.getInstance().setNivel(3);
		Juego.getInstance().setVidas(3);
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(Juego.getInstance().getNivel());
		Ralph ralph = new Ralph();
		ralph.romper(Juego.getInstance().getNivel());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoGrafica window = new JuegoGrafica();
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
	public JuegoGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 432);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		Font font=null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/res/fuente/VCR_OSD_MONO_1.001.ttf"));
			
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(font);
			// makesure to derive the size
			font = font.deriveFont(12f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		
		JLabel lblNivel= new JLabel("NIVEL "+Juego.getInstance().getNivel());
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setFont(font.deriveFont(Font.PLAIN, 28f));
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setBounds(0, 17, 451, 21);
		panel.add(lblNivel);

		JLabel lblPuntaje = new JLabel("PUNTAJE");
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(font.deriveFont(Font.PLAIN, 14f));
		lblPuntaje.setBounds(33, 15, 76, 21);
		panel.add(lblPuntaje);
		
		JLabel Puntaje = new JLabel(Integer.toString(Juego.getInstance().getPuntosJugadorActual()));
		Puntaje.setHorizontalAlignment(SwingConstants.CENTER);
		Puntaje.setFont(font.deriveFont(Font.PLAIN, 21f));
		Puntaje.setForeground(Color.YELLOW);
		Puntaje.setBounds(0, 33, 118, 29);
		panel.add(Puntaje);
		
		JLabel lblVidas = new JLabel("VIDAS");
		lblVidas.setFont(font.deriveFont(Font.PLAIN, 14f));
		lblVidas.setForeground(Color.WHITE);
		lblVidas.setBounds(365, 17, 54, 16);
		panel.add(lblVidas);
		
		calcularVidas(panel);
		
		JLabel lblCuadroVidas = new JLabel("");
		lblCuadroVidas.setIcon(new ImageIcon("/Users/macuduranti/Documents/Facultad/Taller de Lenguajes 2/Fix it Felix Jr./fixitfelixJr_images/cuadro-vidas.png"));
		lblCuadroVidas.setBounds(339,34, 92, 35);
		panel.add(lblCuadroVidas);
		
		JLabel lblForeground = new JLabel("");
		lblForeground.setIcon(new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/cover juego.png")));
		lblForeground.setBounds(-70, -16, 587, 441);
		panel.add(lblForeground);
		
		/*
		 * 
		 * Preguntar si deberia ejecutar calcular obstaculos en cada ejecucion,
		 * ya que es algo que no varia a lo largo del juego y deberia ejecutarse
		 * solo la primera vez
		 * 
		 * Lo mismo con el foreground, hace un new ImageIcon cada vez que se ejecuta.
		 * 
		 */

		// Ventanas Planta Baja
		calcularObstaculos(Niceland.getInstance().edificio[0][0], panel, 105, 330);
		calcularPaneles(Niceland.getInstance().edificio[0][0], panel, 105, 330);
		JLabel lblVentana00 = new JLabel("");
		lblVentana00.setBounds(105, 330 + desp, 38, 60);
		lblVentana00.setIcon(definirSprite(Niceland.getInstance().edificio[0][0]));
		panel.add(lblVentana00);

		calcularObstaculos(Niceland.getInstance().edificio[1][0], panel, 150, 330);
		calcularPaneles(Niceland.getInstance().edificio[1][0], panel, 150, 330);
		JLabel lblVentana10 = new JLabel("");
		lblVentana10.setIcon(definirSprite(Niceland.getInstance().edificio[1][0]));
		lblVentana10.setBounds(150, 330 + desp, 38, 60);
		panel.add(lblVentana10);

		calcularPaneles(Niceland.getInstance().edificio[2][0], panel, 195, 313);
		JLabel lblPlantaBaja = new JLabel("");
		lblPlantaBaja.setIcon(definirSprite(Niceland.getInstance().edificio[2][0]));
		lblPlantaBaja.setBounds(195, 313 + desp, 61, 97);
		panel.add(lblPlantaBaja);

		calcularObstaculos(Niceland.getInstance().edificio[3][0], panel, 260, 330);
		calcularPaneles(Niceland.getInstance().edificio[3][0], panel, 260, 330);
		JLabel lblVentana30 = new JLabel("");
		lblVentana30.setIcon(definirSprite(Niceland.getInstance().edificio[3][0]));
		lblVentana30.setBounds(260, 330 + desp, 38, 60);
		panel.add(lblVentana30);

		calcularObstaculos(Niceland.getInstance().edificio[4][0], panel, 305, 330);
		calcularPaneles(Niceland.getInstance().edificio[4][0], panel, 305, 330);
		JLabel lblVentana40 = new JLabel("");
		lblVentana40.setIcon(definirSprite(Niceland.getInstance().edificio[4][0]));
		lblVentana40.setBounds(305, 330 + desp, 38, 60);
		panel.add(lblVentana40);
		//

		// Ventanas Primer Piso
		calcularObstaculos(Niceland.getInstance().edificio[0][1], panel, 105, 257);
		calcularPaneles(Niceland.getInstance().edificio[0][1], panel, 105, 257);
		JLabel lblVentana01 = new JLabel("");
		lblVentana01.setIcon(definirSprite(Niceland.getInstance().edificio[0][1]));
		lblVentana01.setBounds(105, 257 + desp, 38, 60);
		panel.add(lblVentana01);

		calcularObstaculos(Niceland.getInstance().edificio[1][1], panel, 150, 257);
		calcularPaneles(Niceland.getInstance().edificio[1][1], panel, 150, 257);
		JLabel lblVentana11 = new JLabel("");
		lblVentana11.setIcon(definirSprite(Niceland.getInstance().edificio[1][1]));
		lblVentana11.setBounds(150, 257 + desp, 38, 60);
		panel.add(lblVentana11);

		calcularPaneles(Niceland.getInstance().edificio[2][1], panel, 195, 257);
		JLabel lblPrimerPiso = new JLabel("");
		lblPrimerPiso.setIcon(definirSprite(Niceland.getInstance().edificio[2][1]));
		lblPrimerPiso.setBounds(195, 257 + desp, 62, 56);
		panel.add(lblPrimerPiso);

		calcularObstaculos(Niceland.getInstance().edificio[3][1], panel, 260, 257);
		calcularPaneles(Niceland.getInstance().edificio[3][1], panel, 260, 257);
		JLabel lblVentana31 = new JLabel("");
		lblVentana31.setIcon(definirSprite(Niceland.getInstance().edificio[3][1]));
		lblVentana31.setBounds(260, 257 + desp, 38, 60);
		panel.add(lblVentana31);

		calcularObstaculos(Niceland.getInstance().edificio[4][1], panel, 305, 257);
		calcularPaneles(Niceland.getInstance().edificio[4][1], panel, 305, 257);
		JLabel lblVentana41 = new JLabel("");
		lblVentana41.setIcon(definirSprite(Niceland.getInstance().edificio[4][1]));
		lblVentana41.setBounds(305, 257 + desp, 38, 60);
		panel.add(lblVentana41);
		//

		// Ventanas Segundo Piso
		calcularObstaculos(Niceland.getInstance().edificio[0][2], panel, 105, 176);
		calcularPaneles(Niceland.getInstance().edificio[0][2], panel, 105, 176);
		JLabel lblVentana02 = new JLabel("");
		lblVentana02.setIcon(definirSprite(Niceland.getInstance().edificio[0][2]));
		lblVentana02.setBounds(105, 176 + desp, 38, 60);
		panel.add(lblVentana02);

		calcularObstaculos(Niceland.getInstance().edificio[1][2], panel, 150, 176);
		calcularPaneles(Niceland.getInstance().edificio[1][2], panel, 150, 176);
		JLabel lblVentana12 = new JLabel("");
		lblVentana12.setIcon(definirSprite(Niceland.getInstance().edificio[1][2]));
		lblVentana12.setBounds(150, 176 + desp, 38, 60);
		panel.add(lblVentana12);

		calcularObstaculos(Niceland.getInstance().edificio[2][2], panel, 205, 176);
		calcularPaneles(Niceland.getInstance().edificio[2][2], panel, 205, 176);
		JLabel lblVentana22 = new JLabel("");
		lblVentana22.setIcon(definirSprite(Niceland.getInstance().edificio[2][2]));
		lblVentana22.setBounds(205, 176 + desp, 38, 60);
		panel.add(lblVentana22);

		calcularObstaculos(Niceland.getInstance().edificio[3][2], panel, 260, 176);
		calcularPaneles(Niceland.getInstance().edificio[3][2], panel, 260, 176);
		JLabel lblVentana32 = new JLabel("");
		lblVentana32.setIcon(definirSprite(Niceland.getInstance().edificio[3][2]));
		lblVentana32.setBounds(260, 176 + desp, 38, 60);
		panel.add(lblVentana32);

		calcularObstaculos(Niceland.getInstance().edificio[4][2], panel, 305, 176);
		calcularPaneles(Niceland.getInstance().edificio[4][2], panel, 305, 176);
		JLabel lblVentana42 = new JLabel("");
		lblVentana42.setIcon(definirSprite(Niceland.getInstance().edificio[4][2]));
		lblVentana42.setBounds(305, 176 + desp, 38, 60);
		panel.add(lblVentana42);
		//

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				calcularObstaculos(Niceland.getInstance().edificio[0][j + (i * 3) + 2], panel, 105,
						85 - (70 * (j + (i * 3))) - (24 * i));
				calcularPaneles(Niceland.getInstance().edificio[0][j + (i * 3) + 2], panel, 105,
						85 - (70 * (j + (i * 3))) - (24 * i));
				JLabel lblVentanaW = new JLabel("");
				lblVentanaW.setIcon(definirSprite(Niceland.getInstance().edificio[0][j + (i * 3) + 2]));
				lblVentanaW.setBounds(105, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaW);

				calcularObstaculos(Niceland.getInstance().edificio[1][j + (i * 3) + 2], panel, 150,
						85 - (70 * (j + (i * 3))) - (24 * i));
				calcularPaneles(Niceland.getInstance().edificio[1][j + (i * 3) + 2], panel, 150,
						85 - (70 * (j + (i * 3))) - (24 * i));
				JLabel lblVentanaWM = new JLabel("");
				lblVentanaWM.setIcon(definirSprite(Niceland.getInstance().edificio[1][j + (i * 3) + 2]));
				lblVentanaWM.setBounds(150, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaWM);

				calcularObstaculos(Niceland.getInstance().edificio[2][j + (i * 3) + 2], panel, 205,
						85 - (70 * (j + (i * 3))) - (24 * i));
				calcularPaneles(Niceland.getInstance().edificio[2][j + (i * 3) + 2], panel, 205,
						85 - (70 * (j + (i * 3))) - (24 * i));
				JLabel lblVentanaM = new JLabel("");
				lblVentanaM.setIcon(definirSprite(Niceland.getInstance().edificio[2][j + (i * 3) + 2]));
				lblVentanaM.setBounds(205, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaM);

				calcularObstaculos(Niceland.getInstance().edificio[3][j + (i * 3) + 2], panel, 260,
						85 - (70 * (j + (i * 3))) - (24 * i));
				calcularPaneles(Niceland.getInstance().edificio[3][j + (i * 3) + 2], panel, 260,
						85 - (70 * (j + (i * 3))) - (24 * i));
				JLabel lblVentanaEM = new JLabel("");
				lblVentanaEM.setIcon(definirSprite(Niceland.getInstance().edificio[3][j + (i * 3) + 2]));
				lblVentanaEM.setBounds(260, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaEM);

				calcularObstaculos(Niceland.getInstance().edificio[4][j + (i * 3) + 2], panel, 305,
						85 - (70 * (j + (i * 3))) - (24 * i));
				calcularPaneles(Niceland.getInstance().edificio[4][j + (i * 3) + 2], panel, 305,
						85 - (70 * (j + (i * 3))) - (24 * i));
				JLabel lblVentanaE = new JLabel("");
				lblVentanaE.setIcon(definirSprite(Niceland.getInstance().edificio[4][j + (i * 3) + 2]));
				lblVentanaE.setBounds(305, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
				panel.add(lblVentanaE);
			}
		}

		JLabel lblNiceland = new JLabel("");
		lblNiceland.setIcon(new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/edificio_150.png")));
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

	private void calcularObstaculos(Ventana ventana, JPanel panel, int x, int y) {
		if (ventana instanceof DosPaneles) {
			if (((DosPaneles) ventana).hasMacetero()) {
				JLabel macetero = new JLabel("");
				macetero.setIcon(this.pngMacetero);
				macetero.setBounds(x + 5, y + 46 + desp, 29, 16);
				panel.add(macetero);
			}
			if (((DosPaneles) ventana).hasMoldura()) {
				JLabel moldura = new JLabel("");
				moldura.setIcon(this.pngMoldura);
				moldura.setBounds(x - 1, y + 1 + desp, 40, 10);
				panel.add(moldura);
			}
		}
	}

	private void calcularPaneles(Ventana ventana, JPanel panel, int x, int y) {
		if (ventana instanceof DosPaneles) {
			if (ventana.paneles[0].isParcRoto()) {
				JLabel panel1 = new JLabel("");
				panel1.setIcon(this.pngPanelParc1);
				panel1.setBounds(x + 11, y + 12 + desp, 18, 17);
				panel.add(panel1);
			} else if (ventana.paneles[0].isSano()) {
				JLabel panel1 = new JLabel("");
				panel1.setIcon(this.pngPanelSano);
				panel1.setBounds(x + 10, y + 12 + desp, 20, 16);
				panel.add(panel1);
			}
			if (ventana.paneles[1].isParcRoto()) {
				JLabel panel2 = new JLabel("");
				panel2.setBounds(x + 13, y + 31 + desp, 16, 17);
				panel2.setIcon(this.pngPanelParc2);
				panel.add(panel2);
			} else if (ventana.paneles[1].isSano()) {
				JLabel panel2 = new JLabel("");
				panel2.setBounds(x + 10, y + 31 + desp, 20, 16);
				panel2.setIcon(this.pngPanelSano);
				panel.add(panel2);
			}

		} else if (ventana instanceof PlantaBaja) {
			if (ventana.paneles[0].isParcRoto()) {
				JLabel panel0 = new JLabel("");
				panel0.setIcon(this.pngPanelPBParc1);
				panel0.setBounds(208, 363 + desp, 14, 16);
				panel.add(panel0);
			} else if (ventana.paneles[0].isSano()) {
				JLabel panel0 = new JLabel("");
				panel0.setIcon(this.pngPanelPBSano);
				panel0.setBounds(208, 363 + desp, 14, 16);
				panel.add(panel0);
			}
			if (ventana.paneles[1].isParcRoto()) {
				JLabel panel1 = new JLabel("");
				panel1.setIcon(this.pngPanelPBParc2);
				panel1.setBounds(228, 363 + desp, 14, 16);
				panel.add(panel1);
			} else if (ventana.paneles[1].isSano()) {
				JLabel panel1 = new JLabel("");
				panel1.setIcon(this.pngPanelPBSano);
				panel1.setBounds(228, 363 + desp, 14, 16);
				panel.add(panel1);
			}
			if (ventana.paneles[2].isParcRoto()) {
				JLabel panel2 = new JLabel("");
				panel2.setIcon(this.pngPanelPBParc2);
				panel2.setBounds(208, 381 + desp, 14, 16);
				panel.add(panel2);
			} else if (ventana.paneles[2].isSano()) {
				JLabel panel2 = new JLabel("");
				panel2.setIcon(this.pngPanelPBSano);
				panel2.setBounds(208, 381 + desp, 14, 16);
				panel.add(panel2);
			}
			if (ventana.paneles[3].isParcRoto()) {
				JLabel panel3 = new JLabel("");
				panel3.setIcon(this.pngPanelPBParc1);
				panel3.setBounds(228, 381 + desp, 14, 16);
				panel.add(panel3);
			} else if (ventana.paneles[3].isSano()) {
				JLabel panel3 = new JLabel("");
				panel3.setIcon(this.pngPanelPBSano);
				panel3.setBounds(228, 381 + desp, 14, 16);
				panel.add(panel3);
			}

			
			
		} else if (ventana instanceof PrimerPiso) {
			if (ventana.paneles[0].isParcRoto()) {
				JLabel panel0 = new JLabel("");
				panel0.setIcon(this.pngPanelP1Parc1);
				panel0.setBounds(205, 283 + desp, 8, 10);
				panel.add(panel0);
			} else if (ventana.paneles[0].isRoto()) {
				JLabel panel0 = new JLabel("");
				panel0.setIcon(this.pngPanelP1Roto);
				panel0.setBounds(205, 283 + desp, 8, 10);
				panel.add(panel0);
			}
			if (ventana.paneles[1].isParcRoto()) {
				JLabel panel1 = new JLabel("");
				panel1.setIcon(this.pngPanelP1Parc2);
				panel1.setBounds(226, 283 + desp, 8, 10);
				panel.add(panel1);
			} else if (ventana.paneles[1].isRoto()) {
				JLabel panel1 = new JLabel("");
				panel1.setIcon(this.pngPanelP1Roto);
				panel1.setBounds(226, 283 + desp, 8, 10);
				panel.add(panel1);
			}
			if (ventana.paneles[2].isParcRoto()) {
				JLabel panel2 = new JLabel("");
				panel2.setIcon(this.pngPanelP1Parc2);
				panel2.setBounds(214, 283 + desp, 8, 10);
				panel.add(panel2);
			} else if (ventana.paneles[2].isRoto()) {
				JLabel panel2 = new JLabel("");
				panel2.setIcon(this.pngPanelP1Roto);
				panel2.setBounds(214, 283 + desp, 8, 10);
				panel.add(panel2);
			}
			if (ventana.paneles[3].isParcRoto()) {
				JLabel panel3 = new JLabel("");
				panel3.setIcon(this.pngPanelP1Parc1);
				panel3.setBounds(236, 283 + desp, 8, 10);
				panel.add(panel3);
			} else if (ventana.paneles[3].isRoto()) {
				JLabel panel3 = new JLabel("");
				panel3.setIcon(this.pngPanelP1Roto);
				panel3.setBounds(236, 283 + desp, 8, 10);
				panel.add(panel3);
			}

		}

	}
	
	public void calcularVidas(JPanel panel){
		if (Juego.getInstance().getVidas() == 3 ){
			JLabel vidaFelix = new JLabel("");
			vidaFelix.setIcon(this.pngVidaFelix);
			vidaFelix.setBounds(339, 37, 24, 29);
			panel.add(vidaFelix);
			
			JLabel vidaFelix1 = new JLabel("");
			vidaFelix1.setIcon(this.pngVidaFelix);
			vidaFelix1.setBounds(373, 37, 24, 29);
			panel.add(vidaFelix1);
			
			JLabel vidaFelix2 = new JLabel("");
			vidaFelix2.setIcon(this.pngVidaFelix);
			vidaFelix2.setBounds(407, 37, 24, 29);
			panel.add(vidaFelix2);	
		}else if (Juego.getInstance().getVidas() == 2 ){
			JLabel vidaFelix1 = new JLabel("");
			vidaFelix1.setIcon(this.pngVidaFelix);
			vidaFelix1.setBounds(373, 37, 24, 29);
			panel.add(vidaFelix1);
			
			JLabel vidaFelix2 = new JLabel("");
			vidaFelix2.setIcon(this.pngVidaFelix);
			vidaFelix2.setBounds(407, 37, 24, 29);
			panel.add(vidaFelix2);	
		}else if (Juego.getInstance().getVidas() == 1){
			JLabel vidaFelix2 = new JLabel("");
			vidaFelix2.setIcon(this.pngVidaFelix);
			vidaFelix2.setBounds(407, 37, 24, 29);
			panel.add(vidaFelix2);
		}
	}
}
