package personajes.ralph;

import juego.Juego;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;

public class Ladrillo extends Personaje {

	private double velocidad;
	public boolean enJuego;

	public Ladrillo(int x, int y) {
		this.setEnJuego(true);
		this.setVelocidad(10); // Aca iria el valor de la velocidad modificado
								// por el nivel
		this.setX(x);
		this.setY(y); // Crea el ladrillo en el mismo lugar donde se encuentra
						// ralph
	}

	public void mover() {
		if (getY() > 0)
			this.moverAbajo();
		else {
			setEnJuego(false); // Llego al final y hay que sacarlo del juego
		}
	}

	public double getVelocidad() {

		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

	@Override
	public void atender() {
		if (getY() > 0) {
			this.moverAbajo();
		} else {
			this.eliminar();
		}
		if (Juego.felix.isNormal()) {
			if (Juego.felix.colision(this)) {
				Juego.felix.setEstado(EstadoDeFelix.MUERTO);
				this.eliminar();
			}
		}
	}

	@Override
	public void proxSeccion() {
		this.eliminar();

	}

	public void eliminar() {
		this.setEnJuego(false);
		Juego.getInstance().listaPersonajes.remove(this.getPosLista());
	}

	@Override
	public void reset() {
		this.eliminar();
	}
}
