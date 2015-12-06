package personajes;

import java.util.Timer;
import java.util.TimerTask;

import juego.Juego;

public class TaskDejarPastel extends TimerTask{
	private Nicelander nicelander;
	private Timer timer;
	
	
	public TaskDejarPastel (Nicelander n, Timer t){
		this.nicelander = n;
		this.timer = t;
	}
	
	
	@Override
	public void run() {
		Pastel pastel = new Pastel(this.nicelander.getX(),this.nicelander.getY());
		Juego.getInstance().listaPersonajes.add(pastel);
		this.nicelander.eliminar();
		this.timer.cancel();
	}
	

}
