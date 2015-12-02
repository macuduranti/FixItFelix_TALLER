package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import grafica.CambioSeccion;
import grafica.JuegoGrafica;
import grafica.PantallaPrincipal;
import grafica.TaskSacarCambioSeccion;
import juego.Juego;
import juego.Niceland;
import juego.TaskJuego;

public class ActionListenerJugar implements ActionListener{
	private PantallaPrincipal pantallaprincipal;
	
	public ActionListenerJugar(PantallaPrincipal pp){
		this.pantallaprincipal=pp;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.pantallaprincipal.setVisible(false);	
		Juego juego = new Juego();
		Juego.setInstance(juego);
		switch (Juego.getInstance().getSeccion()) {
		case 0:
			JuegoGrafica.setDesp(0);
			break;
		case 1:
			JuegoGrafica.setDesp(245);
			break;
		case 2:
			JuegoGrafica.setDesp(480);
			break;
		case 3:
			JuegoGrafica.setDesp(715);
			break;
		}
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(Juego.getInstance().getNivel());
		Juego.ralph.romper(Juego.getInstance().getNivel());
		JuegoGrafica juegoGrafica = new JuegoGrafica();
		juegoGrafica.frame.setVisible(true);
		Controller.getInstance().addListeners(juegoGrafica);
		Timer timer = new Timer ("Jugando..");
		TaskJuego tarea = new TaskJuego (juegoGrafica,timer);
		timer.schedule(tarea, 0 , 50);
		CambioSeccion cs = new CambioSeccion();
		cs.setVisible(true);
		cs.setFocusable(false);
		Timer t = new Timer("SacandoCambioSeccion");
		TaskSacarCambioSeccion tscs = new TaskSacarCambioSeccion(cs);
		t.schedule(tscs,2000);
	}
}
