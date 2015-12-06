package personajes;

import java.util.TimerTask;

import juego.Juego;

public class TaskSetInmune extends TimerTask{

	@Override
	public void run() {
		Juego.felix.setInmune(true);
		
	}

}
