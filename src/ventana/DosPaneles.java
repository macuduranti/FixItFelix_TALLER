package ventana;

import java.util.Random;

import juego.Direccion;
import juego.Juego;
import ventana.panel.Panel;

public class DosPaneles extends Ventana {
	public boolean macetero;
	public boolean moldura;

	public DosPaneles() {
		this.paneles = new Panel[2];
		this.paneles[0] = new Panel();
		this.paneles[1] = new Panel();
		this.setMacetero(false);
		this.setMoldura(false);
	}

	public boolean hasMacetero() {
		return macetero;
	}

	public void setMacetero(boolean macetero) {
		this.macetero = macetero;
	}

	public boolean hasMoldura() {
		return moldura;
	}

	public void setMoldura(boolean moldura) {
		this.moldura = moldura;
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
			return arregle;
		} else
			return false;
	}

	@Override
	public boolean romperVentana() {
		Random random = new Random();
		return this.paneles[(int) (random.nextDouble() * 2)].romper();
	}

	@Override
	public boolean puedoPasarDesde(Direccion d) { // Se debe llamar con la
													// proxima
		if (d == Direccion.ABAJO) {
			if (this.hasMacetero())
				return false;
		} else if (d == Direccion.ARRIBA) {
			if (this.hasMoldura()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean puedoPasarHacia(Direccion d) { // Se debe llamar con la
													// actual
		if (d == Direccion.ABAJO) {
			if (this.hasMacetero())
				return false;
		} else if (d == Direccion.ARRIBA) {
			if (this.hasMoldura()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean puedeAparecerNicelander() {
		if (this.paneles[1].isRoto())
			return true;
		else
			return false;
	}

	@Override
	public String getSprite() {
		return "/res/niceland/slice103_@.png";
	}

}