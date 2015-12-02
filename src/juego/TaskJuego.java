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
	public int timesMuerto;
	public Timer timer;

	public TaskJuego(JuegoGrafica juegografica, Timer t) {
		this.jg = juegografica;
		this.timer = t;
	}

	@Override
	public void run() {
		this.jg.frame.repaint();

		if (Juego.getInstance().getVidas() != 0 && Juego.getInstance().getNivel() < 11) {
			Juego.ralph.mover();
			Juego.ralph.sortearLadrillo();
			Juego.sorteador.sortearPajaro();
			for (Personaje personaje : Juego.getInstance().listaPersonajes) {
				personaje.atender();
			}
			if (Juego.felix.isMuerto()) {
				if (timesMuerto == 0)
					Juego.getInstance().setVidas(Juego.getInstance().getVidas() - 1);
				timesMuerto++;
				if (timesMuerto == 40) {
					Juego.felix.setEstado(EstadoDeFelix.NORMAL);
					timesMuerto = 0;
				}
			}
			if (Juego.felix.getCantArreglado() == Juego.ralph.getCantSeccion()) {
				if (Juego.getInstance().getSeccion() != 4) {
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
					CambioSeccion cs = new CambioSeccion();
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

				Juego.getInstance().setNivel(Juego.getInstance().getNivel() + 1);
				Juego.getInstance().setSeccion(0);
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
			PantallaGameOver pgo = new PantallaGameOver();
			pgo.setVisible(true);
		}

	}

}
