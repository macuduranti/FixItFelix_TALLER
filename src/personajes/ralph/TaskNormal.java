package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskNormal extends TimerTask{
	public void run(){
		Juego.ralph.setEstado(EstadoDeRalph.NORMAL);
	}
}
