/**
 * @author Duranti Maximo, Galizia Agustin, Pellegrino Santiago
 * Esta clase es la que lleva a cabo cuando se crea el juego, añade los controller
 * y llama  a pantalla principal
 */
package juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import controller.Controller;
import grafica.PantallaPrincipal;

public class MainJuego {
	public static ArrayList<Puntaje> topFive = new ArrayList<Puntaje>();
	public static ObjectInputStream input = null;
	public static ObjectOutputStream output = null;
	public static ArrayList<Puntaje> getTopFive() {
		return topFive;
	}


	public static void setTopFive(ArrayList<Puntaje> topFive) {
		MainJuego.topFive = topFive;
	}


	public static void main(String[] args) {

		
		try {
			input = new ObjectInputStream(new FileInputStream("save.dat"));
			
		} catch (FileNotFoundException e1) {
			topFive.add(new Puntaje(1500,"Santi"));
			topFive.add(new Puntaje(1400,"Macu"));
			topFive.add(new Puntaje(1300,"Gali"));
			topFive.add(new Puntaje(1600,"Carlos"));
			topFive.add(new Puntaje(1500,"Viru"));
			topFive.sort(Puntaje.getCompartor());
			try {
				output = new ObjectOutputStream(new FileOutputStream("save.dat"));
				output.writeObject(topFive);
				input = new ObjectInputStream(new FileInputStream("save.dat"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
				try {
					topFive = (ArrayList<Puntaje>)input.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		Controller controller = new Controller();
		Controller.setInstance(controller);
		try {
			PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
			PantallaPrincipal.setInstance(pantallaPrincipal);
			controller.addListeners(pantallaPrincipal);
			pantallaPrincipal.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
