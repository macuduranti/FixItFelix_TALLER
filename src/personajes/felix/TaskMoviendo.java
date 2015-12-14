package personajes.felix;

import java.util.TimerTask;

import juego.Juego;

public class TaskMoviendo extends TimerTask{

	@Override
	public void run() {
		if (!Juego.getInstance().felix.isMuerto()) {
			Juego.getInstance().felix.setEstado(EstadoDeFelix.MOVIENDO);
		}
	}

}
