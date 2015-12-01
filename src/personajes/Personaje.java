package personajes;

import juego.Posicion;

public abstract class Personaje {

	public Posicion posicion;
	
	public int xReal;
	public int yReal;
	public int height;
	public int width;

	public int getxReal() {
		return xReal;
	}

	public void setxReal(int xReal) {
		this.xReal = xReal;
	}

	public int getyReal() {
		return yReal;
	}

	public void setyReal(int yReal) {
		this.yReal = yReal;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

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
		this.posicion.setX(x);
	}

	public int getY() {
		return posicion.getY();
	}

	public void setY(int y) {
		this.posicion.setY(y);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
