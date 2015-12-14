package personajes.felix;

import java.util.TimerTask;

import juego.Juego;

public class TaskArreglando1 extends TimerTask{

	@Override
	public void run() {
		Juego.getInstance().felix.setEstado(EstadoDeFelix.ARREGLANDO1);
		
	}

}
