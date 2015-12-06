package personajes;

import java.util.Timer;
import juego.Juego;
import juego.Niceland;
import juego.Posicion;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;
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
		if (!Juego.felix.isMuerto()) {
			if (Juego.felix.colision(this)) {
				// FALTA VER SI AGARRAS OTRO PASTEL ESTANDO INMUNE
				// FALTA VER BIEN EL BUG CUANDO SALEN MAS DE DOS NICELANDERS
				Juego.felix.setEstado(EstadoDeFelix.TOMANDOPASTEL);
				Timer t = new Timer("Inmunizando");
				TaskSetInmune s = new TaskSetInmune();
				TaskUnsetInmune u = new TaskUnsetInmune();
				TaskNormal n = new TaskNormal();
				t.schedule(s, 500);
				t.schedule(n, 500);
				t.schedule(u, 10000);
				this.eliminar();
				((DosPaneles)Niceland.getInstance().edificio[this.getX()][this.getY()]).setNicelander(true);
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
