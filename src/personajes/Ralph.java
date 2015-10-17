package personajes;

import personajes.Personaje;
import juego.Posicion;

public class Ralph extends Personaje {

	
	// Constructor de Ralph
	public Ralph() {
		setX(0);
		setY(0);
		direccion d;
		d = DERECHA;
	}

	public static void Romper(int GolpesNecesarios, Ventana[][] edificio) {
		int i, j;
		double random;
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 3; j++) {
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

	public static void Mover(){
	if (d == DERECHA)
		Ralph.setX(getX() + 1);
	if (d == IZQUIERDA)
		Ralph.setX(getX() - 1);
	if (Ralph.getX() == 4)
		d == IZQUIERDA
	if (Ralph.getX() == 0)
		d == DERECHA
}
}