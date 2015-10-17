package personajes;

import personajes.Personaje;


public class Pastel extends Personaje {

	private static int tiempo;
	private static boolean enJuego;
	private static double aleatorio;
	
	public Pastel(int seccion){
		setEnJuego(true);
		setTiempo(10);
		setAleatorio(Math.random()*100);
		if (aleatorio > 80){
			this.setX(0);
			System.out.print("Un nicelander dejo un pastel en la columna 1");}
		if (aleatorio > 60 && aleatorio < 80){
			this.setX(1);
			System.out.print("Un nicelander dejo un pastel en la columna 2");}
		if (aleatorio > 40 && aleatorio < 60){
			this.setX(2);
			System.out.print("Un nicelander dejo un pastel en la columna 3");}
		if (aleatorio > 20 && aleatorio < 40){
			this.setX(3);
			System.out.print("Un nicelander dejo un pastel en la columna 4");}
		if (aleatorio < 20){
			this.setX(4);
			System.out.print("Un nicelander dejo un pastel en la columna 5");}
		
		
		setAleatorio(Math.random()*100);
		if (aleatorio > 66){
			this.setY(2 + seccion*3);
			System.out.println(" y la fila 3!!");
		}
		if (aleatorio < 33){
			this.setY(1 + seccion*3);
			System.out.println(" y la fila 2!!");
		}
		else{
			this.setY(0 + seccion*3);
			System.out.println(" y la fila 1!!");
		}
		System.out.println("Tienes 10 segundos antes de que desaparezca!!");
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
			if getAleatorio() < 20*(Math.pow(1.15, nivel-1))){
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
	

