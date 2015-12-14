package juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import grafica.CambioSeccion;
import grafica.JuegoGrafica;
import grafica.PantallaGameOver;
import grafica.PasasteNivel;
import grafica.TaskSacarCambioSeccion;
import grafica.TaskSacarPasasteNivel;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;
import personajes.felix.FelixJR;
import personajes.ralph.EstadoDeRalph;
import personajes.ralph.Ralph;

public class TaskJuego extends TimerTask {
	public JuegoGrafica jg;
	public static int timesMuerto=0;
	public static int timesInmune=0;
	public Timer timer;
	private int times = 0;
	public static int tiempo = 120000 - (10000 * Juego.getInstance().getNivel()/2);

	public TaskJuego(JuegoGrafica juegografica, Timer t) {
		this.jg = juegografica;
		this.timer = t;
	}

	@Override
	public void run() {
		this.jg.frame.repaint();
		times ++;
		if (Juego.getInstance().getVidas() != 0 && Juego.getInstance().getNivel() < 11 && tiempo > 0) {
			if (times == 20){
				tiempo-=1000;
				times = 0;
			}
			Juego.ralph.mover();
			Juego.ralph.sortearLadrillo();
			Juego.sorteador.sortearPajaro();
			Juego.sorteador.sortearNicelander();
			for (Personaje personaje : Juego.getInstance().listaPersonajes) {
				personaje.atender();
			}
			if (Juego.felix.isInmune()){
				TaskJuego.setTimesInmune(TaskJuego.getTimesInmune()+1);
				if (TaskJuego.getTimesInmune() == 200) {
					Juego.felix.setInmune(false);
					TaskJuego.setTimesInmune(0);
				}
				
			}
			if (Juego.felix.isMuerto()) {
				if (TaskJuego.getTimesMuerto() == 0)
					Juego.getInstance().setVidas(Juego.getInstance().getVidas() - 1);
				TaskJuego.setTimesMuerto(TaskJuego.getTimesMuerto()+1);
				if (TaskJuego.getTimesMuerto() == 40) {
					Juego.felix.setEstado(EstadoDeFelix.NORMAL);
					TaskJuego.setTimesMuerto(0);
				}
			}
			if (Juego.felix.getCantArreglado() == Juego.ralph.getCantSeccion()) {
				Juego.getInstance().setSeccion(Juego.getInstance().getSeccion() + 1);
				switch (Juego.getInstance().getSeccion()) {
				case 0:
					JuegoGrafica.setDesp(0);
					break;
				case 1:
					JuegoGrafica.setDesp(245);
					break;
				case 2:
					JuegoGrafica.setDesp(480);
					break;
				case 3:
					JuegoGrafica.setDesp(715);
					break;
				}
				Juego.felix.setX(2);
				Juego.felix.setY(Juego.getInstance().getSeccion() * 3);
				Juego.ralph.setyReal(88);
				for (Personaje personaje : Juego.getInstance().listaPersonajes) {
					personaje.reset();
				}
				Juego.felix.setCantArreglado(0);
				Juego.felix.setEstado(EstadoDeFelix.NORMAL);
				Juego.ralph.setEstado(EstadoDeRalph.NORMAL);
				if (Juego.getInstance().getSeccion() != 4) {
					Juego.getInstance().setJugadorActual(Juego.getInstance().getJugadorActual().getPuntos()+300);
					CambioSeccion cs = new CambioSeccion();
					cs.setLocationRelativeTo(jg.frame);
					cs.setVisible(true);
					Timer t = new Timer("SacandoCambioSeccion");
					TaskSacarCambioSeccion tscs = new TaskSacarCambioSeccion(cs);
					t.schedule(tscs, 2000);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (Juego.getInstance().getSeccion() == 4) {
				PasasteNivel pn = new PasasteNivel();
				pn.setLocationRelativeTo(jg.frame);
				pn.setVisible(true);
				Timer t = new Timer("SacandoPasasteNivel");
				TaskSacarPasasteNivel tspn = new TaskSacarPasasteNivel(pn);
				t.schedule(tspn, 3000);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				times = 0;
				tiempo = 120000 - (10000 * Juego.getInstance().getNivel()/2);
				Juego.getInstance().setNivel(Juego.getInstance().getNivel() + 1);
				Juego.getInstance().setSeccion(0);
				CambioSeccion cs = new CambioSeccion();
				cs.setVisible(true);
				TaskSacarCambioSeccion tscs = new TaskSacarCambioSeccion(cs);
				t.schedule(tscs, 2000);
				JuegoGrafica.setDesp(0);
				Juego.ralph = new Ralph();
				Juego.felix = new FelixJR();
				Juego.ralph.romper(Juego.getInstance().getNivel());
				for (Personaje personaje : Juego.getInstance().listaPersonajes) {
					personaje.reset();
				}

			}
		} else {
			this.timer.cancel();
			System.err.println("GAME OVER");
			this.jg.frame.setVisible(false);
			

			Vector<Puntaje> v = new Vector<Puntaje>();
			ObjectInputStream entrada;
			try {
				entrada = new ObjectInputStream(new FileInputStream("puntajes.dat"));
				v = (Vector<Puntaje>) entrada.readObject();
			} catch (FileNotFoundException e) {
				Puntaje p1 = new Puntaje();
				v.addElement(p1);
				v.elementAt(0).setPuntos(100);
				v.elementAt(0).setNombre("Santi Pellegrino");
				Puntaje p2 = new Puntaje();
				v.addElement(p2);
				v.elementAt(1).setPuntos(80);
				v.elementAt(1).setNombre("Agus Galizia");
				Puntaje p5 = new Puntaje();
				v.addElement(p5);
				v.elementAt(2).setPuntos(70);
				v.elementAt(2).setNombre("Macu Duranti");
				Puntaje p3 = new Puntaje();
				v.addElement(p3);
				v.elementAt(3).setPuntos(50);
				v.elementAt(3).setNombre("Steve Jobs");
				Puntaje p4 = new Puntaje();
				v.addElement(p4);
				v.elementAt(4).setPuntos(35);
				v.elementAt(4).setNombre("DIOS");  // ;)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("puntajes.dat"));
			Vector<Puntaje> v = (Vector) entrada.readObject();

			if (Juego.getInstance().jugadorActual.getPuntos() > v.lastElement().puntos) {
				PantallaGameOver pgo = new PantallaGameOver(true);
				pgo.setVisible(true);
			}
			else{
				PantallaGameOver pgo = new PantallaGameOver(false);
				pgo.setVisible(false);
			}
			
		}

	}


	public static int getTimesMuerto() {
		return timesMuerto;
	}


	public static void setTimesMuerto(int timesMuerto) {
		TaskJuego.timesMuerto = timesMuerto;
	}


	public static int getTimesInmune() {
		return timesInmune;
	}


	public static void setTimesInmune(int timesInmune) {
		TaskJuego.timesInmune = timesInmune;
	}

}
