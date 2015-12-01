package personajes.ralph;

import java.util.TimerTask;

public class TaskE1 extends TimerTask{
	private Ladrillo ladrillo;
	
	public TaskE1(Ladrillo l){
		this.ladrillo=l;
	}
	public void run(){
		this.ladrillo.setEstado(EstadoDeLadrillo.E1);
	}
}
