package personajes;

import Personajes.Juego;
import Personajes.personaje;

public class Pastel extends personaje {

	private static int tiempo;
	private static boolean enJuego;
	private static double aleatorio;
	
	public Pastel(){
		setEnJuego(true);
		setTiempo(10);
		setAleatorio(Math.random()*100);
		if (aleatorio > 66)
			Pastel.setX(2);
		if (aleatorio < 33)
			Pastel.setX(0);
		else
			Pastel.setX(1);
		setAleatorio(Math.random()*100);
		if (aleatorio > 80)
			Pastel.setY(4);
		if (aleatorio > 60 && aleatorio < 80)
			Pastel.setY(3);
		if (aleatorio > 40 && aleatorio < 60)
			Pastel.setY(2);
		if (aleatorio > 20 && aleatorio < 40)
			Pastel.setY(1);
		if (aleatorio < 20)
			Pastel.setY(0);
	}
	
	
	public static int getTiempo() {
		return tiempo;
	}

	public static void setTiempo(int tiempo) {
		Pastel.tiempo = tiempo;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public static void setEnJuego(boolean enJuego) {
		Pastel.enJuego = enJuego;
	}
	
	public static double getAleatorio() {
		return aleatorio;
	}

	public static void setAleatorio(double aleatorio) {
		Pastel.aleatorio = aleatorio;
	}
		

	public static void Atender(int nivel) {
		if(enJuego){
			setTiempo(getTiempo() -1);
			if (getTiempo() == 0)
				setEnJuego(false); //Si hay pastel en juego decrementa un segundo el tiempo y si el tiempo llega a cero lo saca
		}
		else{
			setAleatorio(Math.random()*100); //Le da un numero double de 1 a 100
			if (Juego.getNivel() == 1){
				if (getAleatorio() > 70);
					Pastel pastel1 = new Pastel();
			}
			if (Juego.getNivel() == 2){
				if (getAleatorio() > 75);
					Pastel pastel1 = new Pastel();
			}
			if (Juego.getNivel() == 3){
				if (getAleatorio() > 80);
					Pastel pastel1 = new Pastel();
			}
		}
	}
	}
	

