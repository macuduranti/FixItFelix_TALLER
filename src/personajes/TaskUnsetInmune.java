package personajes;

import java.util.TimerTask;

import juego.Juego;

public class TaskUnsetInmune extends TimerTask{

	@Override
	public void run() {
		Juego.getInstance().felix.setInmune(false);
	}

}
