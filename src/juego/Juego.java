package juego;
import personajes.*;
import personajes.felix.*;
import personajes.ralph.Ladrillo;
import personajes.ralph.Ralph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import juego.Niceland;

public class Juego {
	private static Juego instance = new Juego();
	
	public static FelixJR felix = new FelixJR();
	private static Ralph ralph = new Ralph ();
	private static Sorteador sorteador = new Sorteador();
	
	public int nivel;
	public int seccion;
	public Puntaje jugadorActual;
	public int vidas;
	public Puntaje[] puntajesMax;
	public List<Personaje> listaElementos = new ArrayList<Personaje>();
	
	public List<Ladrillo> listaLadrillos = new ArrayList<Ladrillo>();
	public List<Pajaro> listaPajaros = new ArrayList<Pajaro>();
	public List<Pastel> listaPasteles = new ArrayList<Pastel>();
	public List<Nicelander> listaNicelanders = new ArrayList<Nicelander>();
	
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
		int cantSeccion = ralph.romper(this.getNivel());
		this.setSeccion(0);
		int cantArreglado = 0;

		while (this.getSeccion() < 3) { // Cuando seccion llegue a tres, pasa de nivel
			if (this.getVidas() > 0) {
				ralph.atender();
				felix.atender(); //FALTA IMPLEMENTAR BIEN
				
				
				// Sortea si sale un pajaro y lo agrega a la lista de pajaros
				sorteador.sortearPajaro();
				// Sortea si salen ladrillos y agrega 3 a la lista de ladrillos
				ralph.sortearLadrillo();
				// Sortea si sale un nicelander y si deja pastel (los agrega a sus listas)
				sorteador.sortearNicelander();
				
				// Chequea colisiones de los pajaros con felix y los atiende??
				for (Pajaro pajaro : listaPajaros) {
					pajaro.atender();
				}
				// Chequea colisiones de los ladrillos con felix y los atiende??
				for (Ladrillo ladrillo : listaLadrillos) {
					ladrillo.atender();
				}
				// Chequea colisiones de los ladrillos con felix y los atiende??
				for (Pastel pastel : listaPasteles) {
					pastel.atender();
				}
				// Chequea si el nicelander pone un pastel o no, tiene tres intentos
				for (Nicelander nicelander : listaNicelanders) {
					nicelander.atender();
				}
				
				if (felix.isMuerto()){
					this.setVidas(this.getVidas()-1);
					for (Pajaro pajaro : listaPajaros) {
						pajaro.eliminar();
					}
					for (Ladrillo ladrillo : listaLadrillos) {
						ladrillo.eliminar();
					}
					// Los nicelanders y pasteles no desaparecen si moris
					// Los ladrillos siguen callendo (gravedad)
					// Los pajaros siguen pasando
					ralph.reset(); // Ralph deberia dejar de tirar ladrillos y reirse jej
					felix.reset(); // Felix deberia esperar un rato en estado muerto
				}
				if (cantArreglado == cantSeccion){// El cantArreglado, seria un valor que cada vez que arreglas aumenta
					this.setSeccion(this.getSeccion()+1);
					ralph.proxSeccion();
					felix.proxSeccion();
					for (Pajaro pajaro : listaPajaros) {
						pajaro.proxSeccion();
					}
					for (Ladrillo ladrillo : listaLadrillos) {
						ladrillo.proxSeccion();
					}
					for (Nicelander nicelander : listaNicelanders) {
						nicelander.proxSeccion();
					}
					for (Pastel pastel : listaPasteles) {
						pastel.proxSeccion();
					}
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
