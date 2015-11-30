package personajes.felix;

import java.awt.Rectangle;
import java.util.Timer;

import juego.Juego;
import juego.Niceland;
import juego.Posicion;
import personajes.Personaje;

public class FelixJR extends Personaje {
	public EstadoDeFelix estado;
	
	public int height = 53;
	public int width = 24;

	// Constructor de FelixJR
	public FelixJR() {
		this.setEstado(EstadoDeFelix.NORMAL);
		this.posicion=new Posicion(2,0);
		
	}
	
	public boolean colision (Personaje p){
		Rectangle r1 = new Rectangle (this.getxReal(),this.getyReal(),this.getWidth(),this.getHeight());
		Rectangle r2 = new Rectangle (p.getxReal(),p.getyReal(),p.getWidth(),p.getHeight());
		
		if (r1.intersects(r2)){
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
		Timer timer = new Timer("Moviendo");
		TaskMoviendo m = new TaskMoviendo();
		TaskNormal n = new TaskNormal();
		timer.schedule(m, 0);
		timer.schedule(n, 100);
	}

	@Override
	public void moverAbajo() {
		Posicion prox = new Posicion(this.getX(), this.getY() - 1);
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox))) {
			super.moverAbajo();
		}
		Timer timer = new Timer("Moviendo");
		TaskMoviendo m = new TaskMoviendo();
		TaskNormal n = new TaskNormal();
		timer.schedule(m, 0);
		timer.schedule(n, 100);
	}

	@Override
	public void moverDerecha() {
		Posicion prox = new Posicion(this.getX() + 1, this.getY());
		if ((Niceland.getInstance().mePuedoMover(this.getPosicion(),prox))) {
			super.moverDerecha();
		}
		Timer timer = new Timer("Moviendo");
		TaskMoviendo m = new TaskMoviendo();
		TaskNormal n = new TaskNormal();
		timer.schedule(m, 0);
		timer.schedule(n, 100);
	}

	@Override
	public void moverIzquierda() {
		Posicion prox = new Posicion(this.getX() - 1, this.getY());
		if (Niceland.getInstance().mePuedoMover(this.getPosicion(),prox)) { 
			super.moverIzquierda();
		}
		Timer timer = new Timer("Moviendo");
		TaskMoviendo m = new TaskMoviendo();
		TaskNormal n = new TaskNormal();
		timer.schedule(m, 0);
		timer.schedule(n, 100);
	}

	public void arreglar(){
		if (Niceland.getInstance().edificio[this.getX()][this.getY()].arreglarVentana()){
			Juego.getInstance().setJugadorActual(Juego.getInstance().getPuntosJugadorActual()+100);
			Timer timer = new Timer("Arreglando");
			TaskArreglando1 ta1 = new TaskArreglando1();
			TaskArreglando2 ta2 = new TaskArreglando2();
			TaskNormal n = new TaskNormal();
			timer.schedule(ta1, 0);
			timer.schedule(ta2, 50);
			timer.schedule(n, 150);
			
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
	
	public boolean isMoviendo() {
		if (this.getEstado() == EstadoDeFelix.MOVIENDO) {
			return true;
		} else
			return false;
	}
	
	public boolean isArreglando1() {
		if (this.getEstado() == EstadoDeFelix.ARREGLANDO1) {
			return true;
		} else
			return false;
	}
	
	public boolean isArreglando2() {
		if (this.getEstado() == EstadoDeFelix.ARREGLANDO2) {
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