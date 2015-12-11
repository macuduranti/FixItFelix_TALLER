package juego;

import ventana.*;
import java.util.Random;

public class Niceland {

	private static Niceland instance = new Niceland();
	public Ventana[][] edificio = new Ventana[5][12];
	public int cantPaneles[] = {0,0,0,0};
	public int cantMin;
	
	public void generarNiceland(int nivel) {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 12; j++) {
				//if (((i != 2) && (j != 0)) && ((i != 2) && (j != 1))) {
					if (((int) (random.nextDouble() * 100)) < 15) {
						this.edificio[i][j] = new ConHojas();
						if (((int) (random.nextDouble() * 100)) > (20 * (Math.pow(1.15, nivel - 1))))
							((ConHojas) this.edificio[i][j]).setAbierta(true);
					} else {
						this.edificio[i][j] = new DosPaneles();
						if (j <= 2)
							this.cantPaneles[0]=this.cantPaneles[0]+4;
						else if (j >= 3 && j<= 5)
							this.cantPaneles[1]=this.cantPaneles[1]+4;
						else if (j >= 6 && j<=8)
							this.cantPaneles[2]=this.cantPaneles[2]+4;
						else if (j >=9 && j<=11)
							this.cantPaneles[3]=this.cantPaneles[3]+4;
							
						if (((int) (random.nextDouble() * 100)) < (5 * (Math.pow(1.15, nivel - 1))))
							((DosPaneles) this.edificio[i][j]).setMoldura(true);
						if (((int) (random.nextDouble() * 100)) < (5 * (Math.pow(1.15, nivel - 1))))
							((DosPaneles) this.edificio[i][j]).setMacetero(true);
					}
				//}
			}
		}
		this.edificio[2][0] = new PlantaBaja();
		this.cantPaneles[0]=this.cantPaneles[0]+8;
		this.edificio[2][1] = new PrimerPiso();
		this.cantPaneles[0]=this.cantPaneles[0]+8;
		System.out.println("Se ha generado Niceland para nivel "+nivel+".");
		/*
		System.out.println("Hay "+cantPaneles[0]+" paneles rompibles en seccion 0.");
		System.out.println("Hay "+cantPaneles[1]+" paneles rompibles en seccion 1.");
		System.out.println("Hay "+cantPaneles[2]+" paneles rompibles en seccion 2.");
		System.out.println("Hay "+cantPaneles[3]+" paneles rompibles en seccion 3.");
		*/
		setCantMin(Integer.MAX_VALUE);
		for (int i = 0; i < cantPaneles.length; i++) {
			if (cantPaneles[i] < getCantMin()){
				setCantMin(cantPaneles[i]);
			}
		}
		//System.out.println("La cantidad minima de paneles rompibles es "+cantMin);
	}

	public boolean mePuedoMover(Posicion act, Posicion prox) {
		if (prox.getX() > act.getX()) { // Si me muevo a la derecha
			if (prox.getX() <= 4 && this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.IZQUIERDA)
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
			if ((prox.getY() <= 2 + (Juego.getInstance().getSeccion() * 3))
					&& this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.ABAJO)
					&& this.edificio[act.getX()][act.getY()].puedoPasarHacia(Direccion.ARRIBA))
				return true;
			else
				return false;
		} else if (prox.getY() < act.getY()) {// Si me muevo hacia abajo
			if ((prox.getY() >= 0 + (Juego.getInstance().getSeccion() * 3))
					&& this.edificio[prox.getX()][prox.getY()].puedoPasarDesde(Direccion.ARRIBA)
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

	public Ventana[][] getEdificio() {
		return edificio;
	}

	public void setEdificio(Ventana[][] edificio) {
		this.edificio = edificio;
	}

	public int[] getCantPaneles() {
		return cantPaneles;
	}

	public void setCantPaneles(int[] cantPaneles) {
		this.cantPaneles = cantPaneles;
	}

	public int getCantMin() {
		return cantMin;
	}

	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
}
