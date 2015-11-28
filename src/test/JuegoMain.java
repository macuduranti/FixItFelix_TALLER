package test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controller;
import grafica.JuegoGrafica;
import juego.Juego;
import juego.Niceland;

public class JuegoMain {
	public static JuegoGrafica window;
	
	public JuegoMain(){
		Juego juego = new Juego();
		Juego.setInstance(juego);
		Juego.getInstance().setNivel(3);
		Juego.getInstance().setVidas(3);
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(Juego.getInstance().getNivel());
		Juego.ralph.romper(Juego.getInstance().getNivel());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoGrafica window = new JuegoGrafica();
					JuegoMain.window = window;
					window.frame.setVisible(true);
					Controller controller = new Controller(window);
					window.panel.setFocusable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
