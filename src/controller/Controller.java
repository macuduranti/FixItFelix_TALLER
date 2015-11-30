package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import grafica.JuegoGrafica;
import juego.Juego;

public class Controller {
	public Controller(JuegoGrafica view){
		view.panel.addKeyListener(new ListenerTeclas());	
	}
}