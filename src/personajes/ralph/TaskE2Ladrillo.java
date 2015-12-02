package personajes.ralph;

import java.util.TimerTask;

import personajes.ralph.Ladrillo.EstadoDeLadrillo;

public class TaskE2Ladrillo extends TimerTask{
	private Ladrillo ladrillo;
	
	public TaskE2Ladrillo(Ladrillo ladrillo){
		this.ladrillo=ladrillo;
	}
	public void run(){
		this.ladrillo.setEstado(EstadoDeLadrillo.E2);
	}
}
