package controller;

import grafica.JuegoGrafica;
import grafica.PantallaPrincipal;
import personajes.Personaje;

public class Controller {
	private static Controller instance = new Controller();
	
	public void addListeners(JuegoGrafica jg){
		jg.panel.addKeyListener(new ListenerTeclas());
		
	}
	
	public void addListeners(PantallaPrincipal pp){
		pp.btnJugar.addActionListener(new ActionListenerJugar(pp));
		
	}
	
	public void addListeners(JuegoGrafica jg, PantallaPrincipal pp){
		jg.panel.addKeyListener(new ListenerTeclas());
		pp.btnJugar.addActionListener(new ActionListenerJugar(pp));
		
	}
	
	public void tomarPosReal(Personaje p, int xReal, int yReal){
		p.setxReal(xReal);
		p.setyReal(yReal);
	}

	public static Controller getInstance() {
		return instance;
	}

	public static void setInstance(Controller instance) {
		Controller.instance = instance;
	}
}