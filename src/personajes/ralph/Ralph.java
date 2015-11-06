package personajes.ralph;

import java.util.Random;

import juego.Juego;
import juego.Niceland;
import personajes.Personaje;

public class Ralph extends Personaje {

	private int CantidadLadrillos;
	private EstadoDeRalph estado;

	// Constructor de Ralph
	public Ralph() {
		this.setCantidadLadrillos(40);
		this.setEstado(EstadoDeRalph.NORMAL);
		this.setX(2);
		this.setY(3);
	}

	public void mover(int nivel) {
		Random random = new Random();
		int rnd = (int) random.nextDouble() * 100;
		if (rnd <= 50) {
			if (this.getX() > 0) {
				this.moverIzquierda();
			}
		} else if (this.getX() < 5) {
			this.moverDerecha();
		}
	}

	public boolean sortearLadrillo() {
		Random random = new Random();
		if (this.getCantidadLadrillos() < 0) {
			if ((int) random.nextDouble() * 100 < 20 * (Math.pow(1.15, Juego.getInstance().getNivel() - 1))) {
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	public void tirarLadrillo() {
		this.setEstado(EstadoDeRalph.TIRANDO);
	}

	public int romper(int nivel) {
		this.setEstado(EstadoDeRalph.ROMPIENDO);
		Random random = new Random();
		int cantSeccion = 10 * ((int) Math.pow(1.15, nivel - 1));
		int cantAux = cantSeccion;
		for (int i = 0; i <= 2; i++) {
			while (cantAux != 0) { // Rompe cada seccion
				int rndx = (int) random.nextDouble() * 5;
				int rndy = (int) random.nextDouble() * (3 * i) + ((3 * i + 1) - 1);
				if (Niceland.getInstance().edificio[rndx][rndy].romperVentana()) {
					cantAux--;
				}
			}
			cantAux = cantSeccion;
		}
		return cantSeccion;
	}

	public int getCantidadLadrillos() {
		return CantidadLadrillos;
	}

	public void setCantidadLadrillos(int cantidadLadrillos) {
		CantidadLadrillos = cantidadLadrillos;
	}

	public void reset(){
		// Deberia ver como se rie
		this.setEstado(EstadoDeRalph.NORMAL);
	}
	
	@Override
	public void atender() {
		if (this.getEstado() == EstadoDeRalph.NORMAL)
		 this.mover(Juego.getInstance().getNivel());
	}

	@Override
	public void proxSeccion() {
		while (this.getY() < (3 * (Juego.getInstance().getSeccion() + 1) - 1)) {
			this.moverArriba();
		}
		this.setCantidadLadrillos(40);
	}

	public EstadoDeRalph getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeRalph estado) {
		this.estado = estado;
	}

}