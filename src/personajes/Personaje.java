package personajes;

import juego.Posicion;


public abstract class Personaje {
	
	private static Posicion posicion;
	
	//Metodos globales
	public static void mover () {
	}

	public static void Atender(){		
	}

	public int getX() {
		return posicion.getX();
	}

	public void setX(int x) {
		posicion.setX(x);
	}

	public int getY() {
		return posicion.getY();
	}

	public static void setY(int y) {
		posicion.setY(y);
	}
}