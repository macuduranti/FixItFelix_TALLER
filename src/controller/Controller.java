package controller;

import grafica.JuegoGrafica;

public class Controller {
	public Controller(JuegoGrafica view){
		view.panel.addKeyListener(new ListenerTeclas());	
	}
}
