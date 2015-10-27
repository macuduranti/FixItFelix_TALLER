package ventana;

import java.util.Random;

public class DosPaneles extends Ventana {
	public boolean macetero;
	public boolean moldura;

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
		boolean arregle = this.paneles[0].arreglar();
		if (arregle)
			return arregle;
		else
			arregle = this.paneles[1].arreglar();
		return arregle;
	}

	@Override
	public boolean romperVentana() {
		Random random = new Random();
		return this.paneles[(int) random.nextDouble() * 1].romper();
	}
}