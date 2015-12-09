package grafica;

// Cambiar paneles si hay tiempo

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import juego.Juego;
import juego.Niceland;
import juego.TaskJuego;
import personajes.Nicelander;
import personajes.Pajaro;
import personajes.Pastel;
import personajes.Personaje;
import personajes.ralph.Ladrillo;
import ventana.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Timer;
import javax.swing.SwingConstants;
import controller.Controller;

public class JuegoGrafica {
	public final ImageIcon pngVidaFelix = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/vida-felix-small.png"));
	public final ImageIcon pngFelixNormal = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice65_65.png"));
	public final ImageIcon pngFelixMoviendo = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice67_67.png"));
	public final ImageIcon pngFelixArreglando1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice76_76.png"));
	public final ImageIcon pngFelixArreglando2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice84_84.png"));
	public final ImageIcon pngFelixMuerto = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice291_@.png"));
	public final ImageIcon pngFelixPastel = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice600_@.png"));
	public final ImageIcon pngFelixNormalI = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice72_72.png"));
	public final ImageIcon pngFelixMoviendoI = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice67_67I.png"));
	public final ImageIcon pngFelixArreglando1I = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice76_76I.png"));
	public final ImageIcon pngFelixArreglando2I = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice84_84I.png"));

	public final ImageIcon pngLadrillo1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice10_10.png"));
	public final ImageIcon pngLadrillo2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice11_11.png"));

	public final ImageIcon pngNicelander = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice248_@.png"));

	public final ImageIcon pngPastel1 = new ImageIcon(JuegoGrafica.class.getResource("/res/personajes/slice12_12.png"));
	public final ImageIcon pngPastel2 = new ImageIcon(JuegoGrafica.class.getResource("/res/personajes/slice13_13.png"));

	public final ImageIcon pngPajaroI1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice41_41.png"));
	public final ImageIcon pngPajaroI2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice61_61.png"));
	public final ImageIcon pngPajaroD1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice08_08.png"));
	public final ImageIcon pngPajaroD2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice09_09.png"));

	public final ImageIcon pngRalphNormal = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice146_@.png"));
	public final ImageIcon pngRalphMovD1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice147_@.png"));
	public final ImageIcon pngRalphMovD2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice148_@.png"));
	public final ImageIcon pngRalphMovI1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice147_@i.png"));
	public final ImageIcon pngRalphMovI2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/personajes/slice148_@i.png"));

	public final ImageIcon pngConHojasAbierta = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/slice106_@.png"));
	public final ImageIcon pngConHojasCerrada = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/slice105_@.png"));
	public final ImageIcon pngDosPaneles = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/slice103_@.png"));
	public final ImageIcon pngPlantaBaja = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/slice600_@.png"));
	public final ImageIcon pngPrimerPiso = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/slice602_@.png"));

	public final ImageIcon pngPanelParc1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/2p_panel_semi1.png"));
	public final ImageIcon pngPanelParc2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/2p_panel_semi2.png"));
	public final ImageIcon pngPanelSano = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/2p_panel_sano.png"));

	public final ImageIcon pngPanelP1Parc1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/p1_panel_semi1.png"));
	public final ImageIcon pngPanelP1Parc2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/p1_panel_semi2.png"));
	public final ImageIcon pngPanelP1Roto = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/p1_panel_roto.png"));

	public final ImageIcon pngPanelPBParc1 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/pb_panel_semi1.png"));
	public final ImageIcon pngPanelPBParc2 = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/pb_panel_semi2.png"));
	public final ImageIcon pngPanelPBSano = new ImageIcon(
			JuegoGrafica.class.getResource("/res/niceland/pb_panel_sano.png"));

	public final ImageIcon pngMacetero = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/macetero.png"));
	public final ImageIcon pngMoldura = new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/slice22_22.png"));

	private static int desp;
	private static Font font = null;

	public static Controller controller = new Controller();

	// Seccion 1 = desp 0
	// Seccion 2 = desp 245
	// Seccion 3 = desp 480
	// Seccion 4 = desp 715

	public static int getDesp() {
		return desp;
	}

	public static void setDesp(int d) {
		desp = d;
	}

	public JFrame frame;
	public JuegoPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
		Juego.setInstance(juego);
		Juego.getInstance().setNivel(10);
		Juego.getInstance().setSeccion(0);
		switch (Juego.getInstance().getSeccion()) {
		case 0:
			setDesp(0);
			break;
		case 1:
			setDesp(245);
			break;
		case 2:
			setDesp(480);
			break;
		case 3:
			setDesp(715);
			break;
		}

		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(Juego.getInstance().getNivel());
		Juego.ralph.romper(Juego.getInstance().getNivel());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoGrafica window = new JuegoGrafica();
					window.frame.setVisible(true);
					controller.addListeners(window);
					Timer timer = new Timer("Jugando..");
					TaskJuego tarea = new TaskJuego(window, timer);
					timer.schedule(tarea, 0, 50);
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
		frame.setLocationRelativeTo(null);

		panel = new JuegoPanel();
		panel.setFocusable(true);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

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
	}

	/*
	 * 
	 * Hay que ver si mover los maceteros para que entre felix, y si dibujarlos
	 * arriba de felix
	 * 
	 */

	public class JuegoPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void initialize() {

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.removeAll();

			JLabel lblNivel = new JLabel("NIVEL " + Juego.getInstance().getNivel());
			lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNivel.setFont(font.deriveFont(Font.PLAIN, 28f));
			lblNivel.setForeground(Color.WHITE);
			lblNivel.setBounds(0, 5, 451, 21);
			this.add(lblNivel);
			
			int minutes = TaskJuego.tiempo/60000;
			int seconds = ((TaskJuego.tiempo/1000)-(60*minutes));
			String minutos = "00";
			String segundos = "00";
			//System.out.println(minutes+" Minutos, "+seconds+" Segundos");
			if (minutes <= 0){
				minutos="00";
			}else {
				minutos="0"+minutes;
			}
			if (seconds <= 0){
				segundos="00";
			}else if (seconds / 10 < 1){
				segundos="0"+seconds;
			}else {
				segundos=(((Integer)seconds).toString());
			}
			JLabel lblTiempo = new JLabel(minutos+":"+segundos);
			lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTiempo.setFont(font.deriveFont(Font.PLAIN, 24f));
			if (TaskJuego.tiempo <= 10000)
				lblTiempo.setForeground(Color.YELLOW);
			else 
				lblTiempo.setForeground(Color.WHITE);
			lblTiempo.setBounds(0, 30, 451, 21);
			this.add(lblTiempo);

			JLabel lblPuntaje = new JLabel("PUNTAJE");
			lblPuntaje.setForeground(Color.WHITE);
			lblPuntaje.setFont(font.deriveFont(Font.PLAIN, 14f));
			lblPuntaje.setBounds(37, 15, 76, 21);
			this.add(lblPuntaje);

			JLabel Puntaje = new JLabel(Integer.toString(Juego.getInstance().getPuntosJugadorActual()));
			Puntaje.setHorizontalAlignment(SwingConstants.CENTER);
			Puntaje.setFont(font.deriveFont(Font.PLAIN, 21f));
			Puntaje.setForeground(Color.YELLOW);
			Puntaje.setBounds(17, 33, 92, 35);
			this.add(Puntaje);

			JLabel lblCuadroPuntaje = new JLabel("");
			lblCuadroPuntaje.setIcon(new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/cuadro-vidas.png")));
			lblCuadroPuntaje.setBounds(17, 33, 92, 35);
			this.add(lblCuadroPuntaje);

			JLabel lblVidas = new JLabel("VIDAS");
			lblVidas.setFont(font.deriveFont(Font.PLAIN, 14f));
			lblVidas.setForeground(Color.WHITE);
			lblVidas.setBounds(365, 17, 54, 16);
			this.add(lblVidas);

			calcularVidas(this);

			JLabel lblCuadroVidas = new JLabel("");
			lblCuadroVidas.setIcon(new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/cuadro-vidas.png")));
			lblCuadroVidas.setBounds(339, 34, 92, 35);
			this.add(lblCuadroVidas);

			JLabel lblForeground = new JLabel("");
			lblForeground.setIcon(new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/cover juego.png")));
			lblForeground.setBounds(-70, -16, 587, 441);
			this.add(lblForeground);

			/*
			 * 
			 * Preguntar si deberia ejecutar calcular obstaculos en cada
			 * ejecucion, ya que es algo que no varia a lo largo del juego y
			 * deberia ejecutarse solo la primera vez
			 * 
			 * Lo mismo con el foreground, hace un new ImageIcon cada vez que se
			 * ejecuta.
			 * 
			 */
			calcularFelix(this);
			calcularRalph(this);
			calcularPersonajes(this);

			// Ventanas Planta Baja
			calcularObstaculos(Niceland.getInstance().edificio[0][0], this, 105, 330);
			calcularPaneles(Niceland.getInstance().edificio[0][0], this, 105, 330);
			JLabel lblVentana00 = new JLabel("");
			lblVentana00.setBounds(105, 330 + desp, 38, 60);
			lblVentana00.setIcon(definirSprite(Niceland.getInstance().edificio[0][0]));
			this.add(lblVentana00);

			calcularObstaculos(Niceland.getInstance().edificio[1][0], this, 150, 330);
			calcularPaneles(Niceland.getInstance().edificio[1][0], this, 150, 330);
			JLabel lblVentana10 = new JLabel("");
			lblVentana10.setIcon(definirSprite(Niceland.getInstance().edificio[1][0]));
			lblVentana10.setBounds(150, 330 + desp, 38, 60);
			this.add(lblVentana10);

			calcularPaneles(Niceland.getInstance().edificio[2][0], this, 195, 313);
			JLabel lblPlantaBaja = new JLabel("");
			lblPlantaBaja.setIcon(definirSprite(Niceland.getInstance().edificio[2][0]));
			lblPlantaBaja.setBounds(195, 313 + desp, 61, 97);
			this.add(lblPlantaBaja);

			calcularObstaculos(Niceland.getInstance().edificio[3][0], this, 260, 330);
			calcularPaneles(Niceland.getInstance().edificio[3][0], this, 260, 330);
			JLabel lblVentana30 = new JLabel("");
			lblVentana30.setIcon(definirSprite(Niceland.getInstance().edificio[3][0]));
			lblVentana30.setBounds(260, 330 + desp, 38, 60);
			this.add(lblVentana30);

			calcularObstaculos(Niceland.getInstance().edificio[4][0], this, 305, 330);
			calcularPaneles(Niceland.getInstance().edificio[4][0], this, 305, 330);
			JLabel lblVentana40 = new JLabel("");
			lblVentana40.setIcon(definirSprite(Niceland.getInstance().edificio[4][0]));
			lblVentana40.setBounds(305, 330 + desp, 38, 60);
			this.add(lblVentana40);
			//

			// Ventanas Primer Piso
			calcularObstaculos(Niceland.getInstance().edificio[0][1], this, 105, 257);
			calcularPaneles(Niceland.getInstance().edificio[0][1], this, 105, 257);
			JLabel lblVentana01 = new JLabel("");
			lblVentana01.setIcon(definirSprite(Niceland.getInstance().edificio[0][1]));
			lblVentana01.setBounds(105, 257 + desp, 38, 60);
			this.add(lblVentana01);

			calcularObstaculos(Niceland.getInstance().edificio[1][1], this, 150, 257);
			calcularPaneles(Niceland.getInstance().edificio[1][1], this, 150, 257);
			JLabel lblVentana11 = new JLabel("");
			lblVentana11.setIcon(definirSprite(Niceland.getInstance().edificio[1][1]));
			lblVentana11.setBounds(150, 257 + desp, 38, 60);
			this.add(lblVentana11);

			calcularPaneles(Niceland.getInstance().edificio[2][1], this, 195, 257);
			JLabel lblPrimerPiso = new JLabel("");
			lblPrimerPiso.setIcon(definirSprite(Niceland.getInstance().edificio[2][1]));
			lblPrimerPiso.setBounds(195, 257 + desp, 62, 56);
			this.add(lblPrimerPiso);

			calcularObstaculos(Niceland.getInstance().edificio[3][1], this, 260, 257);
			calcularPaneles(Niceland.getInstance().edificio[3][1], this, 260, 257);
			JLabel lblVentana31 = new JLabel("");
			lblVentana31.setIcon(definirSprite(Niceland.getInstance().edificio[3][1]));
			lblVentana31.setBounds(260, 257 + desp, 38, 60);
			this.add(lblVentana31);

			calcularObstaculos(Niceland.getInstance().edificio[4][1], this, 305, 257);
			calcularPaneles(Niceland.getInstance().edificio[4][1], this, 305, 257);
			JLabel lblVentana41 = new JLabel("");
			lblVentana41.setIcon(definirSprite(Niceland.getInstance().edificio[4][1]));
			lblVentana41.setBounds(305, 257 + desp, 38, 60);
			this.add(lblVentana41);
			//

			// Ventanas Segundo Piso
			calcularObstaculos(Niceland.getInstance().edificio[0][2], this, 105, 176);
			calcularPaneles(Niceland.getInstance().edificio[0][2], this, 105, 176);
			JLabel lblVentana02 = new JLabel("");
			lblVentana02.setIcon(definirSprite(Niceland.getInstance().edificio[0][2]));
			lblVentana02.setBounds(105, 176 + desp, 38, 60);
			this.add(lblVentana02);

			calcularObstaculos(Niceland.getInstance().edificio[1][2], this, 150, 176);
			calcularPaneles(Niceland.getInstance().edificio[1][2], this, 150, 176);
			JLabel lblVentana12 = new JLabel("");
			lblVentana12.setIcon(definirSprite(Niceland.getInstance().edificio[1][2]));
			lblVentana12.setBounds(150, 176 + desp, 38, 60);
			this.add(lblVentana12);

			calcularObstaculos(Niceland.getInstance().edificio[2][2], this, 205, 176);
			calcularPaneles(Niceland.getInstance().edificio[2][2], this, 205, 176);
			JLabel lblVentana22 = new JLabel("");
			lblVentana22.setIcon(definirSprite(Niceland.getInstance().edificio[2][2]));
			lblVentana22.setBounds(205, 176 + desp, 38, 60);
			this.add(lblVentana22);

			calcularObstaculos(Niceland.getInstance().edificio[3][2], this, 260, 176);
			calcularPaneles(Niceland.getInstance().edificio[3][2], this, 260, 176);
			JLabel lblVentana32 = new JLabel("");
			lblVentana32.setIcon(definirSprite(Niceland.getInstance().edificio[3][2]));
			lblVentana32.setBounds(260, 176 + desp, 38, 60);
			this.add(lblVentana32);

			calcularObstaculos(Niceland.getInstance().edificio[4][2], this, 305, 176);
			calcularPaneles(Niceland.getInstance().edificio[4][2], this, 305, 176);
			JLabel lblVentana42 = new JLabel("");
			lblVentana42.setIcon(definirSprite(Niceland.getInstance().edificio[4][2]));
			lblVentana42.setBounds(305, 176 + desp, 38, 60);
			this.add(lblVentana42);
			//

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					calcularObstaculos(Niceland.getInstance().edificio[0][j + (i * 3) + 3], this, 105,
							85 - (70 * (j + (i * 3))) - (24 * i));
					calcularPaneles(Niceland.getInstance().edificio[0][j + (i * 3) + 3], this, 105,
							85 - (70 * (j + (i * 3))) - (24 * i));
					JLabel lblVentanaW = new JLabel("");
					lblVentanaW.setIcon(definirSprite(Niceland.getInstance().edificio[0][j + (i * 3) + 3]));
					lblVentanaW.setBounds(105, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
					this.add(lblVentanaW);

					calcularObstaculos(Niceland.getInstance().edificio[1][j + (i * 3) + 3], this, 150,
							85 - (70 * (j + (i * 3))) - (24 * i));
					calcularPaneles(Niceland.getInstance().edificio[1][j + (i * 3) + 3], this, 150,
							85 - (70 * (j + (i * 3))) - (24 * i));
					JLabel lblVentanaWM = new JLabel("");
					lblVentanaWM.setIcon(definirSprite(Niceland.getInstance().edificio[1][j + (i * 3) + 3]));
					lblVentanaWM.setBounds(150, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
					this.add(lblVentanaWM);

					calcularObstaculos(Niceland.getInstance().edificio[2][j + (i * 3) + 3], this, 205,
							85 - (70 * (j + (i * 3))) - (24 * i));
					calcularPaneles(Niceland.getInstance().edificio[2][j + (i * 3) + 3], this, 205,
							85 - (70 * (j + (i * 3))) - (24 * i));
					JLabel lblVentanaM = new JLabel("");
					lblVentanaM.setIcon(definirSprite(Niceland.getInstance().edificio[2][j + (i * 3) + 3]));
					lblVentanaM.setBounds(205, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
					this.add(lblVentanaM);

					calcularObstaculos(Niceland.getInstance().edificio[3][j + (i * 3) + 3], this, 260,
							85 - (70 * (j + (i * 3))) - (24 * i));
					calcularPaneles(Niceland.getInstance().edificio[3][j + (i * 3) + 3], this, 260,
							85 - (70 * (j + (i * 3))) - (24 * i));
					JLabel lblVentanaEM = new JLabel("");
					lblVentanaEM.setIcon(definirSprite(Niceland.getInstance().edificio[3][j + (i * 3) + 3]));
					lblVentanaEM.setBounds(260, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
					this.add(lblVentanaEM);

					calcularObstaculos(Niceland.getInstance().edificio[4][j + (i * 3) + 3], this, 305,
							85 - (70 * (j + (i * 3))) - (24 * i));
					calcularPaneles(Niceland.getInstance().edificio[4][j + (i * 3) + 3], this, 305,
							85 - (70 * (j + (i * 3))) - (24 * i));
					JLabel lblVentanaE = new JLabel("");
					lblVentanaE.setIcon(definirSprite(Niceland.getInstance().edificio[4][j + (i * 3) + 3]));
					lblVentanaE.setBounds(305, 85 - (70 * (j + (i * 3))) - (24 * i) + desp, 38, 60);
					this.add(lblVentanaE);
				}
			}

			JLabel lblNiceland = new JLabel("");
			lblNiceland.setIcon(new ImageIcon(JuegoGrafica.class.getResource("/res/niceland/edificio_150.png")));
			lblNiceland.setBounds(65, -619 + desp, 315, 1028);
			this.add(lblNiceland);
		}
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

	public void calcularVidas(JPanel panel) {
		if (Juego.getInstance().getVidas() == 3) {
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
		} else if (Juego.getInstance().getVidas() == 2) {
			JLabel vidaFelix1 = new JLabel("");
			vidaFelix1.setIcon(this.pngVidaFelix);
			vidaFelix1.setBounds(373, 37, 24, 29);
			panel.add(vidaFelix1);

			JLabel vidaFelix2 = new JLabel("");
			vidaFelix2.setIcon(this.pngVidaFelix);
			vidaFelix2.setBounds(407, 37, 24, 29);
			panel.add(vidaFelix2);
		} else if (Juego.getInstance().getVidas() == 1) {
			JLabel vidaFelix2 = new JLabel("");
			vidaFelix2.setIcon(this.pngVidaFelix);
			vidaFelix2.setBounds(407, 37, 24, 29);
			panel.add(vidaFelix2);
		}
	}

	public void calcularFelix(JPanel panel) {
		int x = 0;
		int y = 0;
		switch (Juego.felix.getX()) {
		case 0:
			x = 100;
			if ((Juego.felix.getY() >= 3) && (Juego.felix.getY() <= 5)) {
				y = 83 - ((Juego.felix.getY() - 3) * 70);
			} else if ((Juego.felix.getY() >= 6) && (Juego.felix.getY() <= 8)) {
				y = -151 - ((Juego.felix.getY() - 6) * 70);
			} else if ((Juego.felix.getY() >= 9) && (Juego.felix.getY() <= 11)) {
				y = -385 - ((Juego.felix.getY() - 9) * 70);
			} else {
				switch (Juego.felix.getY()) {
				case 0:
					y = 330;
					break;
				case 1:
					y = 257;
					break;
				case 2:
					y = 176;
					break;
				}
			}

			break;
		case 1:
			x = 145;
			if ((Juego.felix.getY() >= 3) && (Juego.felix.getY() <= 5)) {
				y = 83 - ((Juego.felix.getY() - 3) * 70);
			} else if ((Juego.felix.getY() >= 6) && (Juego.felix.getY() <= 8)) {
				y = -151 - ((Juego.felix.getY() - 6) * 70);
			} else if ((Juego.felix.getY() >= 9) && (Juego.felix.getY() <= 11)) {
				y = -385 - ((Juego.felix.getY() - 9) * 70);
			} else {
				switch (Juego.felix.getY()) {
				case 0:
					y = 330;
					break;
				case 1:
					y = 257;
					break;
				case 2:
					y = 176;
					break;
				}
			}
			break;
		case 2:
			x = 200;
			if ((Juego.felix.getY() >= 3) && (Juego.felix.getY() <= 5)) {
				y = 83 - ((Juego.felix.getY() - 3) * 70);
			} else if ((Juego.felix.getY() >= 6) && (Juego.felix.getY() <= 8)) {
				y = -151 - ((Juego.felix.getY() - 6) * 70);
			} else if ((Juego.felix.getY() >= 9) && (Juego.felix.getY() <= 11)) {
				y = -385 - ((Juego.felix.getY() - 9) * 70);
			} else {
				switch (Juego.felix.getY()) {
				case 0:
					x = 190;
					y = 358;
					break;
				case 1:
					x = 185;
					y = 259;
					break;
				case 2:
					y = 176;
					break;
				}
			}
			break;
		case 3:
			x = 255;
			if ((Juego.felix.getY() >= 3) && (Juego.felix.getY() <= 5)) {
				y = 83 - ((Juego.felix.getY() - 3) * 70);
			} else if ((Juego.felix.getY() >= 6) && (Juego.felix.getY() <= 8)) {
				y = -151 - ((Juego.felix.getY() - 6) * 70);
			} else if ((Juego.felix.getY() >= 9) && (Juego.felix.getY() <= 11)) {
				y = -385 - ((Juego.felix.getY() - 9) * 70);
			} else {
				switch (Juego.felix.getY()) {
				case 0:
					y = 330;
					break;
				case 1:
					y = 257;
					break;
				case 2:
					y = 176;
					break;
				}
			}
			break;
		case 4:
			x = 300;
			if ((Juego.felix.getY() >= 3) && (Juego.felix.getY() <= 5)) {
				y = 83 - ((Juego.felix.getY() - 3) * 70);
			} else if ((Juego.felix.getY() >= 6) && (Juego.felix.getY() <= 8)) {
				y = -151 - ((Juego.felix.getY() - 6) * 70);
			} else if ((Juego.felix.getY() >= 9) && (Juego.felix.getY() <= 11)) {
				y = -385 - ((Juego.felix.getY() - 9) * 70);
			} else {
				switch (Juego.felix.getY()) {
				case 0:
					y = 330;
					break;
				case 1:
					y = 257;
					break;
				case 2:
					y = 176;
					break;
				}
			}
			break;
		}
		JLabel lblFelix = new JLabel("");
		if (Juego.felix.isNormal()) {
			if (Juego.felix.isInmune()) {
				lblFelix.setIcon(this.pngFelixNormalI);
				lblFelix.setBounds(x, y + desp, 25, 54);
			} else {
				lblFelix.setIcon(this.pngFelixNormal);
				lblFelix.setBounds(x, y + desp, 24, 53);
			}
		} else if (Juego.felix.isMoviendo()) {
			if (Juego.felix.isInmune()) {
				lblFelix.setIcon(this.pngFelixMoviendoI);
				lblFelix.setBounds(x, y + desp, 31, 51);
			} else {
				lblFelix.setIcon(this.pngFelixMoviendo);
				lblFelix.setBounds(x, y + desp, 31, 51);
			}
		} else if (Juego.felix.isArreglando1()) {
			if (Juego.felix.isInmune()) {
				lblFelix.setIcon(this.pngFelixArreglando1I);
				lblFelix.setBounds(x, y + desp, 39, 54);
			} else {
				lblFelix.setIcon(this.pngFelixArreglando1);
				lblFelix.setBounds(x, y + desp, 39, 54);
			}
		} else if (Juego.felix.isArreglando2()) {
			if (Juego.felix.isInmune()) {
				lblFelix.setIcon(this.pngFelixArreglando2I);
				lblFelix.setBounds(x, y + desp, 54, 51);
			} else {
				lblFelix.setIcon(this.pngFelixArreglando2);
				lblFelix.setBounds(x, y + desp, 54, 51);
			}
		} else if (Juego.felix.isTomandoPastel()) {
			lblFelix.setIcon(this.pngFelixPastel);
			lblFelix.setBounds(x, y + desp, 41, 52);
		} else if (Juego.felix.isMuerto()) {
			lblFelix.setIcon(this.pngFelixMuerto);
			lblFelix.setBounds(x, y + desp + 24, 51, 29);
		}
		panel.add(lblFelix);
		controller.tomarPosReal(Juego.felix, x, y + desp);

	}

	public void calcularRalph(JPanel panel) {
		JLabel lblRalph = new JLabel("");
		if (Juego.ralph.isNormal()) {
			lblRalph.setIcon(this.pngRalphNormal);
			lblRalph.setBounds((int) (74 + (Juego.ralph.getXdouble()) * 55), Juego.ralph.getyReal(), 70, 84);
		} else if (Juego.ralph.isMoviendoD1()) {
			lblRalph.setIcon(this.pngRalphMovD1);
			lblRalph.setBounds((int) (74 + (Juego.ralph.getXdouble()) * 55), Juego.ralph.getyReal(), 68, 85);
		} else if (Juego.ralph.isMoviendoD2()) {
			lblRalph.setIcon(this.pngRalphMovD2);
			lblRalph.setBounds((int) (74 + (Juego.ralph.getXdouble()) * 55), Juego.ralph.getyReal(), 66, 87);
		} else if (Juego.ralph.isMoviendoI1()) {
			lblRalph.setIcon(this.pngRalphMovI1);
			lblRalph.setBounds((int) (74 + (Juego.ralph.getXdouble()) * 55), Juego.ralph.getyReal(), 68, 85);
		} else if (Juego.ralph.isMoviendoI2()) {
			lblRalph.setIcon(this.pngRalphMovI2);
			lblRalph.setBounds((int) (74 + (Juego.ralph.getXdouble()) * 55), Juego.ralph.getyReal(), 66, 87);
		}

		panel.add(lblRalph);
	}

	public void calcularPersonajes(JPanel panel) {
		for (Personaje personaje : Juego.getInstance().listaPersonajes) {
			JLabel lblPj = new JLabel("");
			if (personaje instanceof Ladrillo) {
				if (((Ladrillo) personaje).isE1()) {
					lblPj.setIcon(this.pngLadrillo1);
					lblPj.setBounds((int) (74 + (((Ladrillo) personaje).getXdouble()) * 55),
							(int) (((Ladrillo) personaje).getYdouble()), 20, 13);
				} else if (((Ladrillo) personaje).isE2()) {
					lblPj.setIcon(this.pngLadrillo2);
					lblPj.setBounds((int) (74 + (((Ladrillo) personaje).getXdouble()) * 55),
							(int) (((Ladrillo) personaje).getYdouble()), 20, 13);
				}

				//////////////
				controller.tomarPosReal(personaje, (int) (74 + (((Ladrillo) personaje).getXdouble()) * 55),
						(int) (((Ladrillo) personaje).getYdouble()));
			} else if (personaje instanceof Pajaro) {
				if (((Pajaro) personaje).isDerecho()) {
					if (((Pajaro) personaje).isE1()) {
						lblPj.setIcon(this.pngPajaroD1);
						lblPj.setBounds((int) ((((Pajaro) personaje).getXdouble()) * 110),
								(int) (((Pajaro) personaje).getYdouble()), 33, 23);
					} else if (((Pajaro) personaje).isE2()) {
						lblPj.setIcon(this.pngPajaroD2);
						lblPj.setBounds((int) ((((Pajaro) personaje).getXdouble()) * 110),
								(int) (((Pajaro) personaje).getYdouble()), 33, 22);
					}
				} else if (((Pajaro) personaje).isIzquierdo()) {
					if (((Pajaro) personaje).isE1()) {
						lblPj.setIcon(this.pngPajaroI1);
						lblPj.setBounds((int) ((((Pajaro) personaje).getXdouble()) * 110),
								(int) (((Pajaro) personaje).getYdouble()), 34, 21);
					} else if (((Pajaro) personaje).isE2()) {
						lblPj.setIcon(this.pngPajaroI2);
						lblPj.setBounds((int) ((((Pajaro) personaje).getXdouble()) * 110),
								(int) (((Pajaro) personaje).getYdouble()), 35, 21);
					}
				}
				controller.tomarPosReal(personaje, (int) ((((Pajaro) personaje).getXdouble()) * 110),
						(int) (((Pajaro) personaje).getYdouble()));
			} else if (personaje instanceof Nicelander) {
				int x = 0;
				int y = 0;
				switch (personaje.getX()) {
				case 0:
					x = 114;
					break;
				case 1:
					x = 159;
					break;
				case 2:
					x = 214;
					break;
				case 3:
					x = 269;
					break;
				case 4:
					x = 314;
					break;
				}
				if ((personaje.getY() >= 3) && (personaje.getY() <= 5)) {
					y = 83 - ((personaje.getY() - 3) * 70) + 30;
				} else if ((personaje.getY() >= 6) && (personaje.getY() <= 8)) {
					y = -151 - ((personaje.getY() - 6) * 70) + 30;
				} else if ((personaje.getY() >= 9) && (personaje.getY() <= 11)) {
					y = -385 - ((personaje.getY() - 9) * 70) + 30;
				} else {
					switch (personaje.getY()) {
					case 0:
						y = 358;
						break;
					case 1:
						y = 285;
						break;
					case 2:
						y = 204;
						break;
					}
				}
				lblPj.setIcon(this.pngNicelander);
				lblPj.setBounds(x, y + desp, 20, 21);
			} else if (personaje instanceof Pastel) {
				int x = 0;
				int y = 0;
				switch (personaje.getX()) {
				case 0:
					x = 114;
					break;
				case 1:
					x = 159;
					break;
				case 2:
					x = 214;
					break;
				case 3:
					x = 269;
					break;
				case 4:
					x = 314;
					break;
				}
				if ((personaje.getY() >= 3) && (personaje.getY() <= 5)) {
					y = 83 - ((personaje.getY() - 3) * 70) + 30;
				} else if ((personaje.getY() >= 6) && (personaje.getY() <= 8)) {
					y = -151 - ((personaje.getY() - 6) * 70) + 30;
				} else if ((personaje.getY() >= 9) && (personaje.getY() <= 11)) {
					y = -385 - ((personaje.getY() - 9) * 70) + 30;
				} else {
					switch (personaje.getY()) {
					case 0:
						y = 358;
						break;
					case 1:
						y = 285;
						break;
					case 2:
						y = 204;
						break;
					}
				}
				if (((Pastel) personaje).isE1()) {
					lblPj.setIcon(this.pngPastel1);
				} else if (((Pastel) personaje).isE2()) {
					lblPj.setIcon(this.pngPastel2);
				}
				lblPj.setBounds(x, y + desp, 20, 21);
				controller.tomarPosReal(personaje, x, y + desp);
			}
			panel.add(lblPj);
		}
	}

}
