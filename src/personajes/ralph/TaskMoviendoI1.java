package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendoI1 extends TimerTask{
	public void run(){
		Juego.ralph.setEstado(EstadoDeRalph.MOVIENDOI1);
	}
}

