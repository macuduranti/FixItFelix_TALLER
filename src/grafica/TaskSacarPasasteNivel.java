package grafica;

import java.util.TimerTask;

public class TaskSacarPasasteNivel extends TimerTask{

	private PasasteNivel pasasteNivel;
	
	public TaskSacarPasasteNivel(PasasteNivel pn){
		this.pasasteNivel = pn;
	}
	
	@Override
	public void run() {
		this.pasasteNivel.setVisible(false);
	}

}
