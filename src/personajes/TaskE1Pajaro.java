package personajes;

import java.util.TimerTask;

import personajes.Pajaro.EstadoDePajaro;

public class TaskE1Pajaro extends TimerTask{
	private Pajaro pajaro;
	
	public TaskE1Pajaro(Pajaro p){
		this.pajaro=p;
	}
	public void run(){
		this.pajaro.setEstado(EstadoDePajaro.E1);
	}
}
