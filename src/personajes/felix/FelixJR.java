package personajes.felix;

import juego.Juego;
import juego.Niceland;
import juego.Posicion;
import personajes.Personaje;

public class FelixJR extends Personaje {
	public EstadoDeFelix estado;

	// Constructor de FelixJR
	public FelixJR() {
		this.setEstado(new Normal());
	}
	
	public boolean colision (Personaje p){
		if (this.getX() == p.getX() && this.getY() == p.getY()){
			return true;
		}else return false;
	}
	
	@Override
	public void proxSeccion(int seccion){
		while (this.getY()<(3*seccion)){
			this.moverArriba();
		}
	}
	
	@Override
	public void moverArriba() {
		Posicion prox = new Posicion(this.getX(), this.getY() + 1);
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox,Juego.getInstance().getSeccion()))) {
			super.moverArriba();
		}
	}

	@Override
	public void moverAbajo() {
		Posicion prox = new Posicion(this.getX(), this.getY() - 1);
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox,Juego.getInstance().getSeccion()))) {
			super.moverAbajo();
		}
	}

	@Override
	public void moverDerecha() {
		Posicion prox = new Posicion(this.getX() + 1, this.getY());
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox,Juego.getInstance().getSeccion()))) {
			super.moverDerecha();
		}
	}

	@Override
	public void moverIzquierda() {
		Posicion prox = new Posicion(this.getX() - 1, this.getY());
		if (Niceland.getInstance().mePuedoMover(this.getPosicion(),prox,Juego.getInstance().getSeccion())) { 
			super.moverIzquierda();
		}
	}

	public EstadoDeFelix getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeFelix estado) {
		this.estado = estado;
	}

	public boolean isMuerto() {
		if (this.getEstado() instanceof Muerto) {
			return true;
		} else
			return false;
	}

	public boolean isNormal() {
		if (this.getEstado() instanceof Normal) {
			return true;
		} else
			return false;
	}

	public boolean isInmune() {
		if (this.getEstado() instanceof Inmune) {
			return true;
		} else
			return false;
	}
	
	@Override
	public void atender(int nivel) {
		
	}
}