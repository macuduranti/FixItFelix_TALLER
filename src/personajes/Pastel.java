package personajes;

import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import juego.Juego;
import juego.MainJuego;
import juego.Niceland;
import juego.Posicion;
import juego.TaskJuego;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;
import personajes.felix.FelixJR;
import personajes.felix.TaskNormal;
import ventana.DosPaneles;

public class Pastel extends Personaje {
	protected enum EstadoDePastel {
		E1, E2
	}

	public EstadoDePastel estado;

	private int tiempo = (100 * Juego.getInstance().getNivel());

	public Pastel(int x, int y) {
		this.posicion = new Posicion(x, y);
		this.setEstado(EstadoDePastel.E1);
		this.setHeight(20);
		this.setWidth(21);
	}

	@Override
	public void atender() {
		Timer timer = new Timer("Pasteleando");
		TaskE1Pastel e1 = new TaskE1Pastel(this);
		TaskE2Pastel e2 = new TaskE2Pastel(this);
		TaskEliminarPastel e = new TaskEliminarPastel(this,timer);
		timer.schedule(e, 5000);
		if (this.isE1()) {
			timer.schedule(e2, 500);
		} else if (this.isE2()) {
			timer.schedule(e1, 500);
		}
		if (!Juego.getInstance().felix.isMuerto()) {
			if (Juego.getInstance().felix.colision(this)) {
				try {
					Clip clip = AudioSystem.getClip();
			        AudioInputStream ais = AudioSystem.getAudioInputStream(FelixJR.class.getResourceAsStream("/res/sonidos/agarrapastel.wav"));
			        clip.open(ais);
			        clip.loop(0);
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				try {
					MainJuego.clipinmunidad.close();
			        AudioInputStream ais = AudioSystem.getAudioInputStream(FelixJR.class.getResourceAsStream("/res/sonidos/inmunidad.wav"));
			        MainJuego.clipinmunidad.open(ais);
			        MainJuego.clipinmunidad.loop(0);
					} catch (Exception e4) {
						e4.printStackTrace();
					}
				if (Juego.getInstance().felix.isInmune()){
					TaskJuego.setTimesInmune(0);
					try {
						MainJuego.clipinmunidad.close();
				        AudioInputStream ais = AudioSystem.getAudioInputStream(FelixJR.class.getResourceAsStream("/res/sonidos/inmunidad.wav"));
				        MainJuego.clipinmunidad.open(ais);
				        MainJuego.clipinmunidad.loop(0);
						} catch (Exception e4) {
							e4.printStackTrace();
						}
				}
				Juego.getInstance().felix.setEstado(EstadoDeFelix.TOMANDOPASTEL);
				Timer t = new Timer("Inmunizando");
				Juego.getInstance().felix.setInmune(true);
				TaskNormal n = new TaskNormal();
				t.schedule(n, 500);
				this.eliminar();
				((DosPaneles)Niceland.getInstance().edificio[this.getX()][this.getY()]).setNicelander(false);
			}
		}

	}

	@Override
	public void proxSeccion() {
		this.eliminar();
	}

	public void eliminar() {
		Juego.getInstance().listaPersonajes.remove(this);
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public void reset() {
	}

	public EstadoDePastel getEstado() {
		return estado;
	}

	public void setEstado(EstadoDePastel estado) {
		this.estado = estado;
	}

	public boolean isE1() {
		if (this.getEstado() == EstadoDePastel.E1)
			return true;
		else
			return false;
	}

	public boolean isE2() {
		if (this.getEstado() == EstadoDePastel.E2)
			return true;
		else
			return false;
	}

}
