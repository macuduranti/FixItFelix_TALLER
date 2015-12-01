package grafica;

import java.util.TimerTask;

import juego.Juego;
import juego.Niceland;
import personajes.Personaje;

public class TareaPrueba extends TimerTask{
	public JuegoGrafica jg ;
	
	public TareaPrueba (JuegoGrafica juegografica){
		this.jg=juegografica;
	}
	
	
	@Override
	public void run() {
		Niceland.getInstance().edificio[0][0].arreglarVentana();
		this.jg.frame.repaint();
		Juego.ralph.mover();
		Juego.ralph.sortearLadrillo();
		for (Personaje personaje : Juego.getInstance().listaPersonajes) { // Falta implementar el de felix
			personaje.atender();
		}
	}
	
}
