package personajes.ralph;



import java.util.Timer;

import juego.Juego;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;

public class Ladrillo extends Personaje {
	
	public double xdouble;
	public double ydouble;
	
	//public int height = 13;
	//public int width = 20;
	protected enum EstadoDeLadrillo {
		E1, E2
	}
	
	public EstadoDeLadrillo estado;

	public Ladrillo(double x, double y) {
		this.setXdouble(x);
		this.setYdouble(y); // Crea el ladrillo en el mismo lugar donde se encuentra
						// ralph
		this.setEstado(EstadoDeLadrillo.E1);
		
		this.setHeight(13);
		this.setWidth(20);
	}

	@Override
	public void atender() {
		Timer timer = new Timer("Cayendo");
		TaskE1Ladrillo e1 = new TaskE1Ladrillo(this);
		TaskE2Ladrillo e2 = new TaskE2Ladrillo(this);
		if (getYdouble() < 400) {
			if (this.isE1()){
				timer.schedule(e2,300);
			}else if (this.isE2()){
				timer.schedule(e1,300);
			}
			this.moverAbajo();
		} else {
			this.eliminar();
			if (getYdouble() == 400 ){
				timer.cancel();
			}
		}
		if (!Juego.felix.isInmune() && !Juego.felix.isMuerto() && !Juego.felix.isTomandoPastel()) {
			if (Juego.felix.colision(this)) {
				Juego.felix.setEstado(EstadoDeFelix.MUERTO);
				System.out.println("Felix ha muerto");
				this.eliminar();
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
