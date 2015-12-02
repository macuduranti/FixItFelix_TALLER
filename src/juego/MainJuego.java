package juego;

import java.io.IOException;
import controller.Controller;
import grafica.PantallaPrincipal;

public class MainJuego {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Controller.setInstance(controller);
		try {
			PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
			controller.addListeners(pantallaPrincipal);
			pantallaPrincipal.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
