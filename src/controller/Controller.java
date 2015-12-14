package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import juego.Juego;
import juego.MainJuego;
import juego.Puntaje;
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
	
	public void ActualizarLista(String n, int p) throws FileNotFoundException, IOException{
		Juego.getInstance().setJugadorActual(n);
		MainJuego.getTopFive().add(Juego.getInstance().jugadorActual);
		MainJuego.getTopFive().sort(Puntaje.getCompartor());
		if (MainJuego.getTopFive().size() >= 5)
			MainJuego.getTopFive().remove(MainJuego.getTopFive().size()-1);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("save.dat"));
		output.writeObject(MainJuego.getTopFive());
		
	}
	
	public void tomarNivelLista(int n){
		Juego.getInstance().setNivel(n);
	}
}