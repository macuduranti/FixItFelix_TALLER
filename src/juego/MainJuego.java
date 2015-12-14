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
	
	public static ArrayList<Puntaje> getTopFive() {
		return topFive;
	}


	public static void setTopFive(ArrayList<Puntaje> topFive) {
		MainJuego.topFive = topFive;
	}


	public static void main(String[] args) {
		ObjectInputStream input = null;
		ObjectOutputStream output = null;
		try {
			input = new ObjectInputStream(new FileInputStream("/Users/macuduranti/Desktop/personajes.dat"));

		} catch (FileNotFoundException e1) {
			topFive.add(new Puntaje(1500,"Santi"));
			topFive.add(new Puntaje(1400,"Macu"));
			topFive.add(new Puntaje(1300,"Gali"));
			topFive.add(new Puntaje(1600,"Carlos"));
			topFive.add(new Puntaje(1500,"Viru"));
			topFive.sort(Puntaje.getCompartor());
			try {
				output = new ObjectOutputStream(new FileOutputStream("/Users/macuduranti/Desktop/personajes.dat"));
				output.writeObject(topFive);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
				try {
					ArrayList<Puntaje> arrayList = (ArrayList<Puntaje>)input.readObject();
					topFive=arrayList;
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
			controller.addListeners(pantallaPrincipal);
			pantallaPrincipal.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
