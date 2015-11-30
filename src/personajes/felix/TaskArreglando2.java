package personajes.felix;

import java.util.TimerTask;

import juego.Juego;

public class TaskArreglando2 extends TimerTask{
	@Override
	public void run() {
		Juego.felix.setEstado(EstadoDeFelix.ARREGLANDO2);
		
	}

}
