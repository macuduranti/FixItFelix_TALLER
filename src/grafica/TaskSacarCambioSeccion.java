package grafica;

import java.util.TimerTask;

public class TaskSacarCambioSeccion extends TimerTask{

	private CambioSeccion cambioSeccion;
	
	public TaskSacarCambioSeccion(CambioSeccion cs){
		this.cambioSeccion=cs;
	}
	
	@Override
	public void run() {
		this.cambioSeccion.setVisible(false);
	}

}
