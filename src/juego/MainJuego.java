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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import controller.Controller;
import grafica.PantallaPrincipal;
import personajes.felix.FelixJR;

public class MainJuego {
	public static Clip clipinmunidad;
	public static Clip clipmain;
	public static Clip clipjuego;
	public static ArrayList<Puntaje> topFive = new ArrayList<Puntaje>();
	public static ObjectInputStream input = null;
	public static ObjectOutputStream output = null;
	public static ArrayList<Puntaje> getTopFive() {
		return topFive;
	}


	public static void setTopFive(ArrayList<Puntaje> topFive) {
		MainJuego.topFive = topFive;
	}


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			MainJuego.clipinmunidad = AudioSystem.getClip();
		} catch (LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			input = new ObjectInputStream(new FileInputStream("save.dat"));
			
		} catch (FileNotFoundException e1) {
			topFive.add(new Puntaje(1500,"Santi"));
			topFive.add(new Puntaje(1400,"Macu"));
			topFive.add(new Puntaje(1300,"Gali"));
			topFive.add(new Puntaje(1600,"Felix"));
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
			controller.addListeners(pantallaPrincipal);
			pantallaPrincipal.setVisible(true);
			try {
				clipmain = AudioSystem.getClip();
		        AudioInputStream ais = AudioSystem.getAudioInputStream(FelixJR.class.getResource("/res/sonidos/cancionmain.wav"));
		        clipmain.open(ais);
		        clipmain.loop(0);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
