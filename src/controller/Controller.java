package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import grafica.JuegoGrafica;
import juego.Juego;
import personajes.Personaje;

public class Controller {
	
	public void addListeners(JuegoGrafica view){
		view.panel.addKeyListener(new ListenerTeclas());
	}
	
	public void tomarPosReal(Personaje p, int xReal, int yReal){
		p.setxReal(xReal);
		p.setyReal(yReal);
	}
}