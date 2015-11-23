package juego;

import personajes.ralph.Ralph;

public class TestNiceland {

	public static void main(String[] args) {
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(3);
		Ralph ralph = new Ralph();
		ralph.romper(3);
	}

}
