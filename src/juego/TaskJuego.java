package juego;

import java.util.Timer;
import java.util.TimerTask;
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
	public static int timesMuerto = 0;
	public static int timesInmune = 0;
	public Timer timer;
	private int times = 0;
	public static int tiempo = 120000 - (10000 * Juego.getInstance().getNivel() / 2);

	public TaskJuego(JuegoGrafica juegografica, Timer t) {
		this.jg = juegografica;
		this.timer = t;
	}

	@Override
	public void run() {
		this.jg.frame.repaint();
		times++;
		if (Juego.getInstance().getVidas() != 0 && Juego.getInstance().getNivel() < 11 && tiempo > 0) {
			if (times == 20) {
				tiempo -= 1000;
				times = 0;
			}
			Juego.getInstance().ralph.mover();
			Juego.getInstance().ralph.sortearLadrillo();
			Juego.sorteador.sortearPajaro();
			Juego.sorteador.sortearNicelander();
			for (Personaje personaje : Juego.getInstance().listaPersonajes) {
				personaje.atender();
			}
			if (Juego.getInstance().felix.isInmune()) {
				TaskJuego.setTimesInmune(TaskJuego.getTimesInmune() + 1);
				if (TaskJuego.getTimesInmune() == 200) {
					Juego.getInstance().felix.setInmune(false);
					TaskJuego.setTimesInmune(0);
				}

			}
			if (Juego.getInstance().felix.isMuerto()) {
				if (TaskJuego.getTimesMuerto() == 0)
					Juego.getInstance().setVidas(Juego.getInstance().getVidas() - 1);
				TaskJuego.setTimesMuerto(TaskJuego.getTimesMuerto() + 1);
				if (TaskJuego.getTimesMuerto() == 40) {
					Juego.getInstance().felix.setEstado(EstadoDeFelix.NORMAL);
					TaskJuego.setTimesMuerto(0);
				}
			}
			if (Juego.getInstance().felix.getCantArreglado() == Juego.getInstance().ralph.getCantSeccion()) {
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
				Juego.getInstance().felix.setX(2);
				Juego.getInstance().felix.setY(Juego.getInstance().getSeccion() * 3);
				Juego.getInstance().ralph.setyReal(88);
				for (Personaje personaje : Juego.getInstance().listaPersonajes) {
					personaje.reset();
				}
				Juego.getInstance().felix.setCantArreglado(0);
				Juego.getInstance().felix.setEstado(EstadoDeFelix.NORMAL);
				Juego.getInstance().ralph.setEstado(EstadoDeRalph.NORMAL);
				if (Juego.getInstance().getSeccion() != 4) {
					Juego.getInstance().setJugadorActual(Juego.getInstance().getJugadorActual().getPuntos() + 300);
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
				tiempo = 120000 - (10000 * Juego.getInstance().getNivel() / 2);
				Juego.getInstance().setNivel(Juego.getInstance().getNivel() + 1);
				Juego.getInstance().setSeccion(0);
				CambioSeccion cs = new CambioSeccion();
				cs.setLocationRelativeTo(jg.frame);
				cs.setVisible(true);
				TaskSacarCambioSeccion tscs = new TaskSacarCambioSeccion(cs);
				t.schedule(tscs, 2000);
				JuegoGrafica.setDesp(0);
				Juego.getInstance().ralph = new Ralph();
				Juego.getInstance().felix = new FelixJR();
				Juego.getInstance().ralph.romper(Juego.getInstance().getNivel());
				for (Personaje personaje : Juego.getInstance().listaPersonajes) {
					personaje.reset();
				}

			}
		} else {
			this.timer.cancel();
			System.err.println("GAME OVER");
			this.jg.frame.setVisible(false);
			System.out.println(MainJuego.getTopFive().size());
			if (MainJuego.getTopFive().size() >= 5) {
				// ESTO NO ESTARIA FUNCIONANDO TE PREGUNTA IGUAL EL NOMBRE
				if (Juego.getInstance().jugadorActual.getPuntos() > MainJuego.getTopFive().get(4).getPuntos()) {
					PantallaGameOver pgo = new PantallaGameOver(true, this.jg);
					pgo.setVisible(true);
				} else {
					PantallaGameOver pgo = new PantallaGameOver(false, this.jg);
					pgo.setVisible(true);
				}
			} else if (MainJuego.getTopFive().size() < 5) {
				PantallaGameOver pgo = new PantallaGameOver(true, this.jg);
				pgo.setVisible(true);
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
