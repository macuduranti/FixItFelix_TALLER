package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendoI2 extends TimerTask{
	public void run(){
		Juego.getInstance().ralph.setEstado(EstadoDeRalph.MOVIENDOI2);
	}
}

