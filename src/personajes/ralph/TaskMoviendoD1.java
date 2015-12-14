package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendoD1 extends TimerTask{
	public void run(){
		Juego.getInstance().ralph.setEstado(EstadoDeRalph.MOVIENDOD1);
	}
}
