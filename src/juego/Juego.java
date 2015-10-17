package juego;

import personajes.felix.FelixJR;
import juego.Niceland;
import personajes.Ladrillo;
import personajes.Pajaro;
import personajes.Pastel;
import personajes.Ralph;

public class Juego {
	private static Juego instance = new Juego();
	public int nivel;
	public int seccion;
	public Puntaje jugadorActual;
	public int vidas;
	private static int vidasMax = 3;
	public static int GolpesNecesarios;
	public Puntaje[] puntajesMax;

	public static Juego getInstance() {
		return instance;
	}

	public static void setInstance(Juego instance) {
		Juego.instance = instance;
	}

	/*
	 * public Juego(String nombre) { this.setNivel(1); this.setVidas(vidasMax);
	 * this.jugadorActual.setPuntos(0); this.jugadorActual.setNombre(nombre);
	 * 
	 * }
	 */
	public void nuevoJuego() {
		// Juego juego = new Juego(nombre); // Si tiene que ser por constructor
		/**/
		this.setNivel(1);
		this.setSeccion(0);
		this.setVidas(3);
		this.setJugadorActual(0);
		this.setJugadorActual("anonimo");
		/**/

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
		// Lo de aca abajo es para fijarse si entra en el top 5 HAY QUE
		// CAMBIARLO POR Arrays.Sort
		if (this.getJugadorActual().getPuntos() > this.getPuntajesMax()[4].getPuntos()) {
			if (this.getJugadorActual().getPuntos() > this.getPuntajesMax()[3].getPuntos()) {
				if (this.getJugadorActual().getPuntos() > this.getPuntajesMax()[2].getPuntos()) {
					if (this.getJugadorActual().getPuntos() > this.getPuntajesMax()[1].getPuntos()) {
						if (this.getJugadorActual().getPuntos() > this.getPuntajesMax()[0].getPuntos()) {
							this.getPuntajesMax()[0].setNombre(nombre);// Esta
																		// mal
																		// hecho,
																		// faltan
																		// para
																		// cada
																		// posicion,
																		// y
																		// correr
																		// blabla
						}
					}
				}
			}
		}
		// Mostrar puntajes

	}

	private boolean jugarNivel() {
		Niceland.getInstance().generarNiceland(this.getNivel());
		Ralph ralph = new Ralph ();
		int cantSeccion = ralph.romper(this.getNivel());
		this.setSeccion(0);
		FelixJR felix = new FelixJR();
		while (seccion < 3) { // Cuando seccion llegue a tres, pasa de nivel
			if (this.getVidas() > 0) {
				pajaro.atender(nivel,seccion); // La seccion se manda con this.getSeccion();
				pastel.atender(nivel,seccion);
				ralph.atender();
				felix.atender(nivel); // Aca se fijaria si choca con algo
				if (felix.isMuerto()){
					this.setVidas(this.getVidas()-1);
					pajaro.Reset;
					pastel.Reset;
					ralph.Reset;
					felix.Reset;
				}
				if (cantArreglado == cantSeccion){// El cantArreglado, seria un valor que cada vez que arreglas aumenta
					this.setSeccion(this.getSeccion()++);
					pajaro.nextSec;
					pastel.nextSec;
					ralph.nextSec;
					felix.nextSec;
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
