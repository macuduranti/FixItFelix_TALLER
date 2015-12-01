package personajes.ralph;

import java.util.TimerTask;

public class TaskE1Ladrillo extends TimerTask{
	private Ladrillo ladrillo;
	
	public TaskE1Ladrillo(Ladrillo l){
		this.ladrillo=l;
	}
	public void run(){
		this.ladrillo.setEstado(EstadoDeLadrillo.E1);
	}
}
