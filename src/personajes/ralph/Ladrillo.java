package personajes.ralph;



import java.util.Timer;

import juego.Juego;
import personajes.Personaje;

public class Ladrillo extends Personaje {
	
	private double velocidad;
	public boolean enJuego;
	
	public double xdouble;
	public double ydouble;
	
	public int height = 13;
	public int width = 20;
	
	public EstadoDeLadrillo estado;

	public Ladrillo(double x, double y) {
		this.setEnJuego(true);
		this.setVelocidad(10); // Aca iria el valor de la velocidad modificado
								// por el nivel
		this.setXdouble(x);
		this.setYdouble(y); // Crea el ladrillo en el mismo lugar donde se encuentra
						// ralph
		this.setEstado(EstadoDeLadrillo.E1);
	}
	@Deprecated
	public void mover() {
		if (getYdouble() > 0)
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
		Timer timer = new Timer("Cayendo");
		TaskE1 e1 = new TaskE1(this);
		TaskE2 e2 = new TaskE2(this);
		if (getYdouble() <= 400) {
			if (this.isE1()){
				timer.schedule(e2,300);
			}else if (this.isE2()){
				timer.schedule(e1,300);
			}
			this.moverAbajo();
		} else {
			//this.eliminar();
			if (getYdouble() == 401 ){
				timer.cancel();
			}
		}
		if (!Juego.felix.isInmune()) {
			if (Juego.felix.colision(this)) {
				//Juego.felix.setEstado(EstadoDeFelix.MUERTO);
				System.out.println("Felix ha muerto");
				//this.eliminar();
			}
		}
	}
	
	@Override 
	public void moverAbajo(){
		this.setYdouble(this.getYdouble()+5); // Ese cinco deberia incrementar en cada nivel
	}

	@Override
	public void proxSeccion() {
		this.eliminar();

	}

	public void eliminar() {
		this.setEnJuego(false);
		Juego.getInstance().listaPersonajes.remove(this);
	}

	@Override
	public void reset() {
		this.eliminar();
	}

	public double getXdouble() {
		return xdouble;
	}

	public void setXdouble(double xdouble) {
		this.xdouble = xdouble;
	}

	public double getYdouble() {
		return ydouble;
	}

	public void setYdouble(double ydouble) {
		this.ydouble = ydouble;
	}
	
	public EstadoDeLadrillo getEstado() {
		return estado;
	}
	public void setEstado(EstadoDeLadrillo estado) {
		this.estado = estado;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	public boolean isE1(){
		if (this.getEstado()==EstadoDeLadrillo.E1)
				return true;
		else return false;				
	}
	
	public boolean isE2(){
		if (this.getEstado()==EstadoDeLadrillo.E2)
				return true;
		else return false;				
	}
}
