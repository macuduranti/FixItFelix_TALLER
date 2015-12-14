package juego;

public class Test {
	public static boolean main(String[] args) {
		Juego juego = new Juego();
		Juego.setInstance(juego);
		Juego.getInstance().setNivel(10);
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(Juego.getInstance().getNivel());
		return Juego.getInstance().ralph.romper(Juego.getInstance().getNivel());
	}
}
