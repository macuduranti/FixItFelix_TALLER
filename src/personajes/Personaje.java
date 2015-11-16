package personajes;

import juego.Posicion;

public abstract class Personaje {

	public Posicion posicion;

	// Metodos globales
	public void moverArriba() {
		this.setY(this.getY() + 1);
	}

	public void moverAbajo() {
		this.setY(this.getY() - 1);
	}

	public void moverDerecha() {
		this.setX(this.getX() + 1);
	}

	public void moverIzquierda() {
		this.setX(this.getX() - 1);
	}

	public abstract void atender();
	
	public abstract void proxSeccion();

	public abstract void reset();
	
	public int getX() {
		return posicion.getX();
	}

	public void setX(int x) {
		posicion.setX(x);
	}

	public int getY() {
		return posicion.getY();
	}

	public void setY(int y) {
		posicion.setY(y);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
