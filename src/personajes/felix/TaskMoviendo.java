package personajes.felix;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendo extends TimerTask{

	@Override
	public void run() {
		if (!Juego.felix.isMuerto()) {
			Juego.felix.setEstado(EstadoDeFelix.MOVIENDO);
		}
	}

}
