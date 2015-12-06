package personajes;

import java.util.Timer;
import java.util.TimerTask;

import juego.Niceland;
import ventana.DosPaneles;

public class TaskEliminarPastel extends TimerTask{
	private Pastel pastel;
	private Timer timer;
	
	public TaskEliminarPastel(Pastel p, Timer t){
		this.pastel=p;
		this.timer=t;
	}
	public void run(){
		this.pastel.eliminar();
		((DosPaneles)Niceland.getInstance().edificio[this.pastel.getX()][this.pastel.getY()]).setNicelander(false);
		this.timer.cancel();
	}
}
