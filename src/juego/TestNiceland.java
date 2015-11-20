package juego;

public class TestNiceland {

	public static void main(String[] args) {
		Niceland niceland = new Niceland();
		Niceland.setInstance(niceland);
		Niceland.getInstance().generarNiceland(3);
	}

}
