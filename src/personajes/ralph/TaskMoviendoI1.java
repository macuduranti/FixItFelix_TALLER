package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendoI1 extends TimerTask{
	public void run(){
		Juego.getInstance().ralph.setEstado(EstadoDeRalph.MOVIENDOI1);
	}
}

