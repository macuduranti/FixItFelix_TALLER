package juego;

import java.util.Random;

import personajes.Nicelander;
import personajes.Pajaro;

public class Sorteador {

	public void sortearPajaro() {
		Random random = new Random();
		if (Juego.getInstance().getSeccion() != 0) { // En la primer seccion no
														// salen pajaros
			if (((int) (random.nextDouble() * 100)) > 98) {
				// Sortea que salga un pajaro
				Pajaro pajaro = new Pajaro();
				Juego.getInstance().listaPersonajes.add(pajaro);
			}
		}
	}

	public void sortearNicelander() {
		Random random = new Random();
		if (((int) (random.nextDouble() * 10)) > 7) {
			int rndx = ((int) (random.nextDouble() * 5));
			int rndy = ((int) (random.nextDouble() * 3))
					+ ((3 * Juego.getInstance().getSeccion() + 1) - 1);
			System.out.println(rndx +","+ rndy);
			if (Niceland.getInstance().edificio[rndx][rndy].puedeAparecerNicelander()) {
				if ((int) (random.nextDouble() * 3) == 1) {
					Nicelander nicelander = new Nicelander(rndx,rndy);
					Juego.getInstance().listaPersonajes.add(nicelander);
					System.out.println("Aparecio un nicelander en la ventana [" + rndx + "][" + rndy + "]");
				}
			}
		}
	}
}
