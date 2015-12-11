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
	
	public static void ActualizarLista(String n, int p) throws FileNotFoundException, IOException{
		Puntaje nuevo = new Puntaje();
		nuevo.setNombre(n);
		nuevo.setPuntos(p);
		Juego.getInstance().puntajesMax.add(nuevo); //AGREGA A UNA LISTA EL NUEVO
		for(Puntaje p2: Juego.getInstance().getTopFive()) {Juego.getInstance().puntajesMax.add(p2);}
		Collections.sort(Juego.getInstance().puntajesMax, Puntaje.getCompartor());
		
		Juego.getInstance().puntajesMax.remove(5); //BORRA EL ULTIMO ELEMENTO DE LA LISTA
		Vector<Puntaje> topFive = new Vector<Puntaje>(); 
		for(Puntaje p1:  Juego.getInstance().puntajesMax) { topFive.add(p1); }
		
		ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("puntajes.dat")); 
		
		try {archivo.writeObject(topFive); }
		catch (IOException e) { // TODO Auto-generated catch block
		e.printStackTrace(); }
		
	}
}