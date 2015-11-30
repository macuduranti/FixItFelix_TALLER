package grafica;

import java.util.TimerTask;

import juego.Juego;
import juego.Niceland;

public class TareaPrueba extends TimerTask{
	public JuegoGrafica jg ;
	
	public TareaPrueba (JuegoGrafica juegografica){
		this.jg=juegografica;
	}
	
	
	@Override
	public void run() {
		Niceland.getInstance().edificio[0][0].arreglarVentana();
		this.jg.frame.repaint();
		System.out.println(Juego.felix.getX());
	}
	
}
