package personajes.felix;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendo extends TimerTask{

	@Override
	public void run() {
			Juego.felix.setEstado(EstadoDeFelix.MOVIENDO);
	}

}
