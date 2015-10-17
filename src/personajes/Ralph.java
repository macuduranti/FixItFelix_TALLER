package personajes;

import java.util.Random;

import juego.Posicion;
import ventana.ConHojas;
import ventana.DosPaneles;
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
			Ralph.moverDerecha();
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) //SI NO HAY LADRILLO EN JUEGO Y RALPH TIENE PARA TIRAR
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); //Deberia ver como ladrillo es parte de ralph
			return;
		}
		if (getX() == 4){
			setX(getX() -1);
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) 
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); 
			return;	// Cuida de que no se caiga
		}
		setAleatorio(Math.random() *100);
		if (getAleatorio() < 50)
			setX(getX()+1);
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) 
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); 
		else
			setX(getX()-1);
			if (!Ladrillo.isEnJuego() && getCantidadLadrillos() > 0) 
				if(SortearLadrillo(nivel))
					Ladrillo ladrillo = new ladrillo(getX(), getY()); 
	}
	
	
	
	public boolean SortearLadrillo(int nivel){
		setAleatorio(Math.random()*100);
		if(getAleatorio() < 20*(Math.pow(1.15, nivel-1))){
			return true;
		}else return false;
	}
	
	 
	
	
	public int romper(int nivel) { //FALTA VER!!
		int cantSeccion = 10 * ((int) Math.pow(1.15, nivel - 1));
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; i++) {
				if ((i != 0 && j != 2) && (i != 1 && j != 2)) {
				
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				random = Math.random() * 100; // VERIFICAR SI SE LE PUEDE
												// ASIGNAR ASI UN VALOR RANDOM
				if (random > 80) {
					edificio[i][j].setEstado(2);
					GolpesNecesarios = GolpesNecesarios + 2;
				}
				if (random < 80 && random > 50) {
					edificio[i][j].setEstado(1);
					GolpesNecesarios = GolpesNecesarios + 1;
				}
				if (random < 50) {
					edificio[i][j].setEstado(0);
				}
			}
		}
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


}