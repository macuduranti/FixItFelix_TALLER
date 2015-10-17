package juego;

import ventana.*;

public class Niceland {

	public Ventana[][] edificio = new Ventana[5][9];

	public Niceland() {
		this.edificio[0][2] = new PlantaBaja();
		this.edificio[1][2] = new PrimerPiso();
	}

	public boolean mePuedoMover(Posicion act, Posicion prox, int seccion) {
		if (prox.getX() > act.getX()) { // Si me muevo a la derecha
			if ((this.edificio[prox.getX()][prox.getY()] instanceof ConHojas)
					&& (((ConHojas) this.edificio[prox.getX()][prox.getY()]).isAbierta())) {
				return false; // Si a la derecha hay una ConHojas abierta
			} else if (prox.getX() > 5)
				return false;
			else
				return true;
		} else if (prox.getX() < act.getX()) {// Si me muevo a la Izquierda
			if ((this.edificio[act.getX()][act.getY()] instanceof ConHojas)
					&& (((ConHojas) this.edificio[act.getX()][act.getY()]).isAbierta())) {
				return false; // Si estoy en una ConHojas abierta
			} else if (prox.getX() < 0)
				return false;
			else
				return true;
		} else if (prox.getY() > act.getY()) {// Si me muevo hacia arriba
			if ((this.edificio[act.getX()][act.getY()] instanceof DosPaneles)
					&& (((DosPaneles) this.edificio[act.getX()][act.getY()]).hasMoldura())) {
				return false; // Si estoy en una con moldura
			} else if ((this.edificio[prox.getX()][prox.getY()] instanceof DosPaneles)
					&& (((DosPaneles) this.edificio[prox.getX()][prox.getY()]).hasMacetero())) {
				return false; // Si arriba hay una con macetero
			} else if (prox.getY() > 2 + (seccion * 3))
				return false;
			else
				return true;
		} else if (prox.getY() < act.getY()) {// Si me muevo hacia abajo
			if ((this.edificio[act.getX()][act.getY()] instanceof DosPaneles)
					&& (((DosPaneles) this.edificio[act.getX()][act.getY()]).hasMacetero())) {
				return false; // Si estoy en una con macetero
			} else if ((this.edificio[prox.getX()][prox.getY()] instanceof DosPaneles)
					&& (((DosPaneles) this.edificio[prox.getX()][prox.getY()]).hasMoldura())) {
				return false; // Si abajo hay una con moldura
			} else if (prox.getY() < 0 + (seccion * 3))
				return false;
			else
				return true;
		}
		return false;
	}
}
