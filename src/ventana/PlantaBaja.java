package ventana;

import java.util.Random;
import juego.Direccion;
import juego.Juego;
import ventana.panel.Panel;

public class PlantaBaja extends Ventana {

	public PlantaBaja() {
		this.paneles = new Panel[4];
		this.paneles[0] = new Panel();
		this.paneles[1] = new Panel();
		this.paneles[2] = new Panel();
		this.paneles[3] = new Panel();

	}

	@Override
	public boolean arreglarVentana() {// Devuelve boolean si pudo arreglar para
		// hacer la animacion o no, si devuelve
		// true podria incrementar una variable
		// que sea cantidad de veces arregladas
		// que compare con cantidad de veces a
		// arreglar (generada cuando ralph
		// rompe) para ver si se paso el nivel o
		// no
		if (!Juego.felix.isMuerto()) {
			boolean arregle = this.paneles[0].arreglar();
			if (arregle)
				return arregle;
			else
				arregle = this.paneles[1].arreglar();
			if (arregle)
				return arregle;
			else
				arregle = this.paneles[2].arreglar();
			if (arregle)
				return arregle;
			else
				arregle = this.paneles[3].arreglar();
			return arregle;
		} else
			return false;
	}

	@Override
	public boolean romperVentana() {
		Random random = new Random();
		return this.paneles[(int) (random.nextDouble() * 4)].romper();
	}

	@Override
	public boolean puedoPasarDesde(Direccion d) {
		return true;
	}

	@Override
	public boolean puedoPasarHacia(Direccion d) {
		return true;
	}

	@Override
	public boolean puedeAparecerNicelander() {
		return false;
	}

	@Override
	public String getSprite() {
		return "/res/niceland/slice600_@.png";
	}
}
