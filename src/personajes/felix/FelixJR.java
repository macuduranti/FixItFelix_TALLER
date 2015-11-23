package personajes.felix;

import juego.Juego;
import juego.Niceland;
import juego.Posicion;
import personajes.Personaje;

public class FelixJR extends Personaje {
	public EstadoDeFelix estado;

	// Constructor de FelixJR
	public FelixJR() {
		this.setEstado(EstadoDeFelix.NORMAL);
		this.posicion=new Posicion(2,0);
	}
	
	public boolean colision (Personaje p){
		if (this.getX() == p.getX() && this.getY() == p.getY()){
			return true;
		}else return false;
	}
	
	@Override
	public void proxSeccion(){
		while (this.getY()<(3*Juego.getInstance().getSeccion())){
			super.moverArriba();
		}
	}
	
	@Override
	public void moverArriba() {
		Posicion prox = new Posicion(this.getX(), this.getY() + 1);
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox))) {
			super.moverArriba();
		}
	}

	@Override
	public void moverAbajo() {
		Posicion prox = new Posicion(this.getX(), this.getY() - 1);
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox))) {
			super.moverAbajo();
		}
	}

	@Override
	public void moverDerecha() {
		Posicion prox = new Posicion(this.getX() + 1, this.getY());
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox))) {
			super.moverDerecha();
		}
	}

	@Override
	public void moverIzquierda() {
		Posicion prox = new Posicion(this.getX() - 1, this.getY());
		if (Niceland.getInstance().mePuedoMover(this.getPosicion(),prox)) { 
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
		if (this.getEstado() == EstadoDeFelix.MUERTO) {
			return true;
		} else
			return false;
	}

	public boolean isNormal() {
		if (this.getEstado() == EstadoDeFelix.NORMAL) {
			return true;
		} else
			return false;
	}

	public boolean isInmune() {
		if (this.getEstado() == EstadoDeFelix.INMUNE) {
			return true;
		} else
			return false;
	}
	
	public void reset(){
		// Deberia ver como espera para revivir 
		this.setEstado(EstadoDeFelix.NORMAL);
	}
	
	@Override
	public void atender() {
	}
}