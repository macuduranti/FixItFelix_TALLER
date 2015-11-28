package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import grafica.JuegoGrafica;
import grafica.PantallaPrincipal;

public class ActionListenerJugar implements ActionListener{
	private PantallaPrincipal pantallaprincipal;
	
	public ActionListenerJugar(PantallaPrincipal pantallaprincipal){
		this.pantallaprincipal=pantallaprincipal;
	}
	
	public void actionPerformed(ActionEvent e) {
		((Component) e.getSource()).getParent().getParent().setVisible(false);
		JuegoGrafica JframeJuego = new JuegoGrafica();
		JframeJuego.frame.setVisible(true);

		
		//Esto es todo para el test, no deberia ser asi - NO DARLE BOLA
		/*JuegoMain juegomain = new JuegoMain();
		Timer timer = new Timer("Imprimir....");
		JuegoTask task = new JuegoTask();
		timer.schedule(task, 0, 10);*/
	}
}
