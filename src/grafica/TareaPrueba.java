package grafica;

import java.util.TimerTask;
import juego.Juego;
import personajes.Personaje;
import personajes.felix.EstadoDeFelix;

public class TareaPrueba extends TimerTask {
	public JuegoGrafica jg;
	public TareaPrueba(JuegoGrafica juegografica) {
		this.jg = juegografica;
	}

	public int timesMuerto;

	@Override
	public void run() {
		this.jg.frame.repaint();
		Juego.ralph.mover();
		Juego.ralph.sortearLadrillo();
		for (Personaje personaje : Juego.getInstance().listaPersonajes) {		
			personaje.atender();
		}
		if (Juego.felix.isMuerto()) {
			if (timesMuerto == 0)
				Juego.getInstance().setVidas(Juego.getInstance().getVidas() - 1);
			timesMuerto++;
			if (timesMuerto == 40) {
				Juego.felix.setEstado(EstadoDeFelix.NORMAL);
				timesMuerto = 0;
			}
		}
		if (Juego.felix.getCantArreglado() == Juego.ralph.getCantSeccion()) {
			Juego.getInstance().setSeccion(Juego.getInstance().getSeccion() + 1);
			switch (Juego.getInstance().getSeccion()) {
			case 0:
				JuegoGrafica.setDesp(0);
				break;
			case 1:
				JuegoGrafica.setDesp(245);
				break;
			case 2:
				JuegoGrafica.setDesp(480);
				break;
			case 3:
				JuegoGrafica.setDesp(715);
				break;
			}
			Juego.felix.setX(2);
			Juego.felix.setY(Juego.getInstance().getSeccion()*3);
			Juego.ralph.setyReal(88);
			for (Personaje personaje : Juego.getInstance().listaPersonajes) {		
				personaje.reset();
			}
			Juego.felix.setCantArreglado(0);
		}

	}

}
