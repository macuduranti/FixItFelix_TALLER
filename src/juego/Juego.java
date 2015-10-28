package juego;
// PRUEBA
import personajes.*;
import personajes.felix.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import juego.Niceland;

public class Juego {
	private static Juego instance = new Juego();
	public int nivel;
	public int seccion;
	public Puntaje jugadorActual;
	public int vidas;
	private static int vidasMax = 3;
	public Puntaje[] puntajesMax;
	public List<Personaje> listaElementos = new ArrayList<Personaje>();

	public static Juego getInstance() {
		return instance;
	}

	public static void setInstance(Juego instance) {
		Juego.instance = instance;
	}

	public void nuevoJuego() {
		this.setNivel(1);
		this.setSeccion(0);
		this.setVidas(3);
		this.setJugadorActual(0);
		while (this.getVidas() > 0 && this.getNivel() <= 10) {
			if (jugarNivel()) {
				this.setNivel(this.getNivel() + 1);
				// Deberia borrar todos los personajes ya que los crea de nuevo
				// Pasaste de nivel
			} else {
				break;
			}
		}
		// Game over
		// Lee el nombre en nombre
		String nombre = "Lo que lea";
		this.setJugadorActual(nombre);
		this.getPuntajesMax()[5] = this.getJugadorActual();
		Arrays.sort(this.getPuntajesMax());

	}

	private boolean jugarNivel() {
		Niceland.getInstance().generarNiceland(this.getNivel());
		Ralph ralph = new Ralph ();
		int cantSeccion = ralph.romper(this.getNivel());
		this.setSeccion(0);
		int cantArreglado = 0;
		FelixJR felix = new FelixJR();
		while (this.getSeccion() < 3) { // Cuando seccion llegue a tres, pasa de nivel
			if (this.getVidas() > 0) {
				pajaro.atender(nivel,seccion); // La seccion se manda con this.getSeccion();
				pastel.atender(nivel,seccion)
				if (sortearPajaro()){ // Creo que tendria que ser algo asi
					Pajaro pajaro = new Pajaro(this.getSeccion());
				}
				ralph.atender();
				for (Personaje p : listaElementos) { // Se fija si choca con ladrillo pajaro o pastel
					if ((p instanceof Pajaro || p instanceof Ladrillo) && felix.colision(p))
						felix.setEstado(new Muerto());
					else 
						if (p instanceof Pastel && felix.colision(p))
							felix.setEstado(new Inmune());
				}
				if (felix.isMuerto()){
					this.setVidas(this.getVidas()-1);
					pajaro.Reset;
					pastel.Reset;
					ralph.Reset;
					felix.Reset;
				}
				if (cantArreglado == cantSeccion){// El cantArreglado, seria un valor que cada vez que arreglas aumenta
					this.setSeccion(this.getSeccion()++);
					ralph.proxSeccion(this.getSeccion());
					felix.proxSeccion(this.getSeccion());
					cantArreglado = 0;
					// Estos metodos lo que hacen es mover todo a la siguiente seccion
				}
			} else return false; // Si no tiene mas vidas 
		}
		return true;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Puntaje getJugadorActual() {
		return jugadorActual;
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

	public Puntaje[] getPuntajesMax() {
		return puntajesMax;
	}

	public void setPuntajesMax(Puntaje[] puntajesMax) {
		this.puntajesMax = puntajesMax;
	}

}
