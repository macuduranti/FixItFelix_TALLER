package personajes.ralph;

import java.util.TimerTask;

public class TaskE2 extends TimerTask{
	private Ladrillo ladrillo;
	
	public TaskE2(Ladrillo ladrillo){
		this.ladrillo=ladrillo;
	}
	public void run(){
		this.ladrillo.setEstado(EstadoDeLadrillo.E2);
	}
}
