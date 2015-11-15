package personajes;

import juego.Juego;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;

public class Pastel extends Personaje {

	private boolean enJuego;
	private int tiempo = (100 * Juego.getInstance().getNivel());

	public Pastel(int x, int y) {
		this.setEnJuego(true);
		this.setX(x);
		this.setY(y);
	}

	public boolean isEnJuego() {
		return this.enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

	@Override
	public void atender() {
		if (Juego.felix.colision(this)) {
			Juego.felix.setEstado(EstadoDeFelix.INMUNE);
			this.eliminar();
		}
		this.setTiempo(getTiempo() - 1);
		if (getTiempo() == 0)
			this.eliminar();
	}

	@Override
	public void proxSeccion() {
		this.eliminar();
	}

	public void eliminar() {
		this.setEnJuego(false);
		Juego.getInstance().listaPersonajes.remove(this.getPosLista());
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

}
