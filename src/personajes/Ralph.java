package personajes;

import java.util.Random;

import juego.Niceland;
import juego.Posicion;
import ventana.*;
import ventana.panel.Sano;

public class Ralph extends Personaje {

	private double Aleatorio;
	private int CantidadLadrillos;

	// Constructor de Ralph
	public Ralph() {
		setX(2);
		setY(2);
	}

	public void mover(int nivel){
		if(getX() == 0){
			this.moverDerecha();
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) //SI NO HAY LADRILLO EN JUEGO Y RALPH TIENE PARA TIRAR
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); //Deberia ver como ladrillo es parte de ralph
			return;
		}
		if (getX() == 4){
			this.moverIzquierda();
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) 
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); 
			return;	// Cuida de que no se caiga
		}
		setAleatorio(Math.random() *100);
		if (getAleatorio() < 50)
			this.moverDerecha();
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) 
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); 
		else
			this.moverIzquierda();
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) 
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); 
	}

	public boolean SortearLadrillo(int nivel) {
		setAleatorio(Math.random() * 100);
		if (getAleatorio() < 20 * (Math.pow(1.15, nivel - 1))) {
			return true;
		} else
			return false;
	}

	public int romper(int nivel) {
		Random random = new Random();
		int cantSeccion = 10 * ((int) Math.pow(1.15, nivel - 1));
		int cantAux = cantSeccion;
		while (cantAux != 0) { // Rompe la primer seccion
			int rndx = (int) random.nextDouble() * 5;
			int rndy = (int) random.nextDouble() * 3;
			if (!(Niceland.getInstance().edificio[rndx][rndy] instanceof ConHojas)) {
				if (Niceland.getInstance().edificio[rndx][rndy] instanceof DosPaneles) {
					if (Niceland.getInstance().edificio[rndx][rndy].paneles[(int) random.nextDouble() * 1].romper()) {
						cantAux--;
					}
				} else if (Niceland.getInstance().edificio[rndx][rndy] instanceof PlantaBaja) {
					if (Niceland.getInstance().edificio[rndx][rndy].paneles[(int) random.nextDouble() * 3].romper()) {
						cantAux--;
					}
				} else if (Niceland.getInstance().edificio[rndx][rndy] instanceof PrimerPiso) {
					if (Niceland.getInstance().edificio[rndx][rndy].paneles[(int) random.nextDouble() * 7].romper()) {
						cantAux--;
					}
				}
			}
		}
		cantAux = cantSeccion;
		for (int i = 1; i <= 2; i++) {
			while (cantAux != 0) { // Rompe la segunda y tercer seccion
				int rndx = (int) random.nextDouble() * 5;
				int rndy = (int) random.nextDouble() * (3*i) + ((3*i+1)-1);
				if (Niceland.getInstance().edificio[rndx][rndy] instanceof DosPaneles) {
					if (Niceland.getInstance().edificio[rndx][rndy].paneles[(int) random.nextDouble() * 1].romper()) {
						cantAux--;
					}
				}
			}
			cantAux = cantSeccion;
		}
		return cantSeccion;
	}

	public double getAleatorio() {
		return Aleatorio;
	}

	public void setAleatorio(double aleatorio) {
		Aleatorio = aleatorio;
	}

	public int getCantidadLadrillos() {
		return CantidadLadrillos;
	}

	public void setCantidadLadrillos(int cantidadLadrillos) {
		CantidadLadrillos = cantidadLadrillos;
	}

	@Override
	public void Atender() {
		// TODO Auto-generated method stub
		
	}

}