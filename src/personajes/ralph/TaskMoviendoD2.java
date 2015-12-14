package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendoD2 extends TimerTask{
	public void run(){
		Juego.getInstance().ralph.setEstado(EstadoDeRalph.MOVIENDOD2);
	}
}
