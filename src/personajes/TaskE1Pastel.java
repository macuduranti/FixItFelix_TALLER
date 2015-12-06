package personajes;

import java.util.TimerTask;
import personajes.Pastel.EstadoDePastel;

public class TaskE1Pastel extends TimerTask{
	private Pastel pastel;
	
	public TaskE1Pastel(Pastel p){
		this.pastel=p;
	}
	public void run(){
		this.pastel.setEstado(EstadoDePastel.E1);
	}
}
