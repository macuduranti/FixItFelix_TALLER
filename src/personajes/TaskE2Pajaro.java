package personajes;

import java.util.TimerTask;

import personajes.Pajaro.EstadoDePajaro;

public class TaskE2Pajaro extends TimerTask{
	private Pajaro pajaro;
	
	public TaskE2Pajaro(Pajaro p){
		this.pajaro=p;
	}
	public void run(){
		this.pajaro.setEstado(EstadoDePajaro.E2);
	}
}
