package juego;

import ventana.*;
import ventana.panel.Sano;
import java.util.Random;

public class Niceland {

	private static Niceland instance = new Niceland();
	public Ventana[][] edificio = new Ventana[5][9];

	public void generarNiceland(int nivel) {
		this.edificio[0][2] = new PlantaBaja();
		for (int i = 0; i < 4; i++) {
			this.edificio[0][2].paneles[i].setEstado(new Sano());
		}
		this.edificio[1][2] = new PrimerPiso();
		for (int i = 0; i < 8; i++) {
			this.edificio[1][2].paneles[i].setEstado(new Sano());
		}
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; i++) {
				if ((i != 0 && j != 2) && (i != 1 && j != 2)) {
					if (((int) random.nextDouble() * 100) < 15) {
						this.edificio[i][j] = new ConHojas();
						if (((int) random.nextDouble() * 100) < (20 * (Math.pow(1.15, nivel - 1)))) {
							((ConHojas) this.edificio[i][j]).setAbierta(true);
						} else
							((ConHojas) this.edificio[i][j]).setAbierta(false);
					} else {
						this.edificio[i][j] = new DosPaneles();
						((DosPaneles) this.edificio[i][j]).paneles[0].setEstado(new Sano());
						((DosPaneles) this.edificio[i][j]).paneles[1].setEstado(new Sano());
						((DosPaneles) this.edificio[i][j]).setMoldura(false);
						((DosPaneles) this.edificio[i][j]).setMacetero(false);
						if (((int) random.nextDouble() * 100) < (10 * (Math.pow(1.15, nivel - 1)))) {
							((DosPaneles) this.edificio[i][j]).setMoldura(true);
						}
						if (((int) random.nextDouble() * 100) < (10 * (Math.pow(1.15, nivel - 1)))) {
							((DosPaneles) this.edificio[i][j]).setMacetero(true);
						}
					}
				}
			}
		}
	}

	public boolean mePuedoMover(Posicion act, Posicion prox, int seccion) {
		if (prox.getX() > act.getX()) { // Si me muevo a la derecha
			if (prox.getX() <= 5 && this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.IZQUIERDA)
					&& this.edificio[act.getX()][act.getY()].puedoPasarHacia(Direccion.DERECHA))
				return true;
			else
				return false;
		} else if (prox.getX() < act.getX()) {// Si me muevo a la Izquierda
			if (prox.getX() >= 0 && this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.DERECHA)
					&& this.edificio[act.getX()][act.getY()].puedoPasarHacia(Direccion.IZQUIERDA))
				return true;
			else
				return false;
		} else if (prox.getY() > act.getY()) {// Si me muevo hacia arriba
			if ((prox.getY() <= 2 + (seccion * 3)) && this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.ABAJO)
					&& this.edificio[act.getX()][act.getY()].puedoPasarHacia(Direccion.ARRIBA))
				return true;
			else
				return false;
		} else if (prox.getY() < act.getY()) {// Si me muevo hacia abajo
			if ((prox.getY() >= 0 + (seccion * 3)) && this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.ARRIBA)
					&& this.edificio[act.getX()][act.getY()].puedoPasarHacia(Direccion.ABAJO))
				return true;
			else
				return false;
		}
		return false;
	}

	public static Niceland getInstance() {
		return instance;
	}

	public static void setInstance(Niceland instance) {
		Niceland.instance = instance;
	}
}
