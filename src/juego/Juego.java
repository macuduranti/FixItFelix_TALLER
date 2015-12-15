package juego;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import grafica.PantallaPrincipal;
import personajes.Personaje;
import personajes.felix.FelixJR;
import personajes.ralph.Ralph;

public class Juego {
	private static Juego instance = new Juego();

	public FelixJR felix = new FelixJR();
	public Ralph ralph = new Ralph();
	public static Sorteador sorteador = new Sorteador();

	public int nivel;
	public int seccion;
	public Puntaje jugadorActual;
	public int vidas;
	public ArrayList<Puntaje> puntajesMax;

	public CopyOnWriteArrayList<Personaje> listaPersonajes = new CopyOnWriteArrayList<Personaje>();
	
	public static Juego getInstance() {
		return instance;
	}

	public static void setInstance(Juego instance) {
		Juego.instance = instance;
	}
	
	public Juego(){
		this.setNivel(PantallaPrincipal.getNivelInicial());
		this.setSeccion(0);
		this.setVidas(3);
		this.jugadorActual = new Puntaje(); //CREA UN NUEVO OBJETO PUNJATE
	}
	

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Puntaje getJugadorActual() {
		return this.jugadorActual;
	}

	public int getPuntosJugadorActual() {
		return this.jugadorActual.getPuntos();
	}
	
	public void setJugadorActual(String name) {
		this.jugadorActual.setNombre(name);
	}

	public void setJugadorActual(int puntos) {
		this.jugadorActual.setPuntos(puntos);
	}

	public void setJugadorActual(Puntaje jugadorActual) {
		this.jugadorActual = jugadorActual;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getSeccion() {
		return seccion;
	}

	public void setSeccion(int seccion) {
		this.seccion = seccion;
	}

}
