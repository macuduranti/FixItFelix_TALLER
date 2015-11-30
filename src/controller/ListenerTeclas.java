package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import juego.Juego;

public class ListenerTeclas implements KeyListener{
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int ckey= e.getKeyCode(); 
		switch (ckey) {
		case 37:
			Juego.felix.moverIzquierda();
			break;
		case 38: // Arriba
			Juego.felix.moverArriba();
			break;
		case 39:
			Juego.felix.moverDerecha();
			break;
		case 40: // Abajo
			Juego.felix.moverAbajo();
			break;
		case 32: // Barra
			Juego.felix.arreglar();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

