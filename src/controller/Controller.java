package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import juego.Juego;
import juego.MainJuego;
import juego.Puntaje;
import grafica.JuegoGrafica;
import grafica.PantallaPrincipal;
import personajes.Personaje;

public class Controller {
	private static Controller instance = new Controller();
	
	public void addListeners(JuegoGrafica jg){
		jg.panel.addKeyListener(new ListenerTeclas());
		
	}
	
	public void addListeners(PantallaPrincipal pp){
		pp.btnJugar.addActionListener(new ActionListenerJugar(pp));
		
	}
	
	public void addListeners(JuegoGrafica jg, PantallaPrincipal pp){
		jg.panel.addKeyListener(new ListenerTeclas());
		pp.btnJugar.addActionListener(new ActionListenerJugar(pp));
		
	}
	
	public void tomarPosReal(Personaje p, int xReal, int yReal){
		p.setxReal(xReal);
		p.setyReal(yReal);
	}

	public static Controller getInstance() {
		return instance;
	}

	public static void setInstance(Controller instance) {
		Controller.instance = instance;
	}
	
	public void ActualizarLista(String n, int p) throws FileNotFoundException, IOException{
		Juego.getInstance().setJugadorActual(n);
		MainJuego.getTopFive().add(Juego.getInstance().getJugadorActual());
		MainJuego.getTopFive().sort(Puntaje.getCompartor());
		if (MainJuego.getTopFive().size() >= 5)
			MainJuego.getTopFive().remove(MainJuego.getTopFive().size()-1);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("save.dat"));
		output.writeObject(MainJuego.getTopFive());
		output.close();
	}
	
	public void ActualizarListaReemplazando(String n, int p, int index) throws FileNotFoundException, IOException{
		System.out.println("Reemplazando la posicion "+index);
		Juego.getInstance().setJugadorActual(n);
		MainJuego.getTopFive().remove(index);
		MainJuego.getTopFive().add(Juego.getInstance().getJugadorActual());
		MainJuego.getTopFive().sort(Puntaje.getCompartor());
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("save.dat"));
		output.writeObject(MainJuego.getTopFive());
		output.close();
	}
	
	public boolean BuscarCoincidencia (String n, int[] i){
		System.out.println("Chequeando coincidencias");
		for (Puntaje puntaje : MainJuego.getTopFive()) {
			if (puntaje.getNombre().compareTo(n) == 0){
				i[0] = MainJuego.getTopFive().indexOf(puntaje);
				System.out.println(i[0]);
				return true;
			}
		}
		return false;
	}
	
	public boolean BuscarEspacios (String n){
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(n);
		return matcher.find();
	}
	
	public void tomarNivelLista(int n){
		Juego.getInstance().setNivel(n);
	}
}