package personajes.ralph;

import java.util.TimerTask;

import juego.Juego;

public class TaskQuietoStop extends TimerTask{

	@Override
	public void run() {
		Juego.getInstance().ralph.setQuieto(false);
	}

}
