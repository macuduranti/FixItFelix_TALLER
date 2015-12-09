package personajes.ralph;

import java.util.Random;
import java.util.Timer;

import juego.Direccion;
import juego.Juego;
import juego.Niceland;
import personajes.Personaje;

public class Ralph extends Personaje {

	private int CantidadLadrillos;
	private EstadoDeRalph estado;
	public double xdouble;
	public double ydouble;
	private int cantMov;
	public int cantMovs;
	private Direccion ultDir;
	public boolean quieto;
	public int cantSeccion;

	// Constructor de Ralph
	public Ralph() {
		this.setCantidadLadrillos(40);
		this.setEstado(EstadoDeRalph.NORMAL);
		this.setyReal(78);
		this.setXdouble(2);
		this.setYdouble(3);
		this.setCantMov(0);

		/*
		 * PISOS 3 78 6 88 9 88 12 88
		 * END 400
		 */

		/*
		 * VENTANAS 0 90 1 135 2 188 3 245 4 290
		 */

	}

	public void mover() {
		Random random = new Random();
		if (this.cantMovs == 3) {
			this.setQuieto(true);
			Timer timer = new Timer("Quietando");
			TaskQuietoStop q = new TaskQuietoStop();
			timer.schedule(q, 2000);
			this.cantMovs = 0;
			Juego.ralph.setEstado(EstadoDeRalph.NORMAL);
		}
		if (!this.isQuieto()) {
			if (this.getCantMov() == 0) {
				this.setCantMov((int) (random.nextDouble() * 21 + 10));
				int rnd = (int) (random.nextDouble() * 2);
				if (rnd == 0) {
					if (this.getXdouble() > 0) {
						this.moverIzquierda();
						this.setUltDir(Direccion.IZQUIERDA);
					}
				} else if (rnd == 1) {
					if (this.getXdouble() < 4) {
						this.moverDerecha();
						this.setUltDir(Direccion.DERECHA);
					}
				}
				this.cantMovs++;
			} else {
				if (this.ultDir == Direccion.IZQUIERDA) {
					if (this.getXdouble() > 0)
						this.moverIzquierda();
					else if (this.getXdouble() == 0)
						this.setUltDir(Direccion.DERECHA);
				} else if (this.ultDir == Direccion.DERECHA) {
					if (this.getXdouble() < 4)
						this.moverDerecha();
					else if (this.getXdouble() == 4)
						this.setUltDir(Direccion.IZQUIERDA);
				}
				this.setCantMov(this.getCantMov() - 1);
				//if (this.getCantMov() == 0){
				//	this.setEstado(EstadoDeRalph.NORMAL);
				//}
			}
		}
	}

	@Override
	public void moverIzquierda() {
		this.setXdouble(this.getXdouble() - 0.1);
		Timer timer = new Timer("Moviendo");
		TaskMoviendoI1 i1 = new TaskMoviendoI1();
		TaskMoviendoI2 i2 = new TaskMoviendoI2();
		// TaskNormal n = new TaskNormal();
		if (this.isMoviendoI1()){
			timer.schedule(i2, 300);
			//timer.schedule(i1, 300);
		}else if (this.isMoviendoI2()){
			timer.schedule(i1, 300);
			//timer.schedule(i2, 300);
		}else{
			timer.schedule(i1, 0);
			//timer.schedule(i2, 300);
		}
		if (this.getCantMov() == 0){
			timer.cancel();
			this.setEstado(EstadoDeRalph.NORMAL);
		}

		// timer.schedule(n, 200);
	}

	@Override
	public void moverDerecha() {
		this.setXdouble(this.getXdouble() + 0.1);
		Timer timer = new Timer("Moviendo");
		TaskMoviendoD1 d1 = new TaskMoviendoD1();
		TaskMoviendoD2 d2 = new TaskMoviendoD2();
		// TaskNormal n = new TaskNormal();
		if (this.isMoviendoD1()){
			timer.schedule(d2, 300);
			//timer.schedule(d1, 300);
		}else if (this.isMoviendoD2()){
			timer.schedule(d1, 300);
			//timer.schedule(d2, 300);
		}else {
			timer.schedule(d1, 0);
			//timer.schedule(d2, 300);
		}
		// timer.schedule(n, 200);
		if (this.getCantMov() == 0){
			timer.cancel();
			this.setEstado(EstadoDeRalph.NORMAL);
		}
	}

	public void sortearLadrillo() {
		Random random = new Random();
		if (this.getCantidadLadrillos() > 0 && this.isQuieto()) {
			if ((int) (random.nextDouble() * 100) < 2 * (Math.pow(1.15, Juego.getInstance().getNivel() - 1))) {
				Ladrillo ladrillo = new Ladrillo(this.getXdouble() + random.nextDouble() , this.getyReal() + 80);
				Juego.getInstance().listaPersonajes.add(ladrillo);
				/*Ladrillo ladrillo2 = new Ladrillo(this.getXdouble()-0.5, this.getyReal());
				Juego.getInstance().listaPersonajes.add(ladrillo2);
				Ladrillo ladrillo3 = new Ladrillo(this.getXdouble(), this.getyReal());
				Juego.getInstance().listaPersonajes.add(ladrillo3);*/
				this.setCantidadLadrillos(this.getCantidadLadrillos() - 1);
				System.out.println("Ralph ha tirado un ladrillo, le quedan "+Juego.ralph.getCantidadLadrillos());
			}
		}
	}

	public void tirarLadrillo() {
		this.setEstado(EstadoDeRalph.TIRANDO);
	}

	public boolean romper(int nivel) {
		this.setEstado(EstadoDeRalph.ROMPIENDO);
		Random random = new Random();
		//this.setCantSeccion(Integer.MAX_VALUE);
		this.setCantSeccion((int) (10 * Math.pow(1.15, nivel - 1)));
		if (this.getCantSeccion() > Niceland.getInstance().cantMin)
			this.setCantSeccion(Niceland.getInstance().cantMin);
		int cantAux = this.getCantSeccion();
		for (int i = 0; i <= 3; i++) {
			while (cantAux != 0) { // Rompe cada seccion
				int rndx = (int) (random.nextDouble() * 5);
				int rndy = (int) (random.nextDouble() * 3 + (3 * i));
				if (Niceland.getInstance().edificio[rndx][rndy].romperVentana()) {
					cantAux--;
				}
			}
			cantAux = this.getCantSeccion();
		}
		System.out.println("Ralph ha roto niceland");
		this.setEstado(EstadoDeRalph.NORMAL);
		return true;
	}

	public int getCantidadLadrillos() {
		return CantidadLadrillos;
	}

	public void setCantidadLadrillos(int cantidadLadrillos) {
		CantidadLadrillos = cantidadLadrillos;
	}

	public void reset() {
		// Deberia ver como se rie
		this.setEstado(EstadoDeRalph.NORMAL);
	}

	@Override
	public void atender() {
		if (this.getEstado() == EstadoDeRalph.NORMAL)
			this.mover();
	}

	@Override
	public void proxSeccion() {
		while (this.getY() < (3 * (Juego.getInstance().getSeccion() + 1) - 1)) {
			this.moverArriba();
		}
	}

	public boolean isNormal() {
		if (this.getEstado() == EstadoDeRalph.NORMAL) {
			return true;
		} else
			return false;
	}

	public boolean isTirando() {
		if (this.getEstado() == EstadoDeRalph.TIRANDO) {
			return true;
		} else
			return false;
	}

	public boolean isMoviendoI1() {
		if (this.getEstado() == EstadoDeRalph.MOVIENDOI1) {
			return true;
		} else
			return false;
	}

	public boolean isMoviendoI2() {
		if (this.getEstado() == EstadoDeRalph.MOVIENDOI2) {
			return true;
		} else
			return false;
	}

	public boolean isMoviendoD1() {
		if (this.getEstado() == EstadoDeRalph.MOVIENDOD1) {
			return true;
		} else
			return false;
	}

	public boolean isMoviendoD2() {
		if (this.getEstado() == EstadoDeRalph.MOVIENDOD2) {
			return true;
		} else
			return false;
	}

	public EstadoDeRalph getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeRalph estado) {
		this.estado = estado;
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

	public int getCantMov() {
		return cantMov;
	}

	public void setCantMov(int cantMov) {
		this.cantMov = cantMov;
	}

	public Direccion getUltDir() {
		return ultDir;
	}

	public void setUltDir(Direccion ultDir) {
		this.ultDir = ultDir;
	}

	public boolean isQuieto() {
		return quieto;
	}

	public void setQuieto(boolean quieto) {
		this.quieto = quieto;
	}

	public int getCantMovs() {
		return cantMovs;
	}

	public void setCantMovs(int cantMovs) {
		this.cantMovs = cantMovs;
	}

	public int getCantSeccion() {
		return cantSeccion;
	}

	public void setCantSeccion(int cantSeccion) {
		this.cantSeccion = cantSeccion;
	}

}