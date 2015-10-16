package ventana;

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

	public boolean arreglarVentana() {// Devuelve boolean si pudo arreglar para
										// hacer la animacion o no, si devuelve
										// true podria incrementar una variable
										// que sea cantidad de veces arregladas
										// que compare con cantidad de veces a
										// arreglar (generada cuando ralph
										// rompe) para ver si se paso el nivel o
										// no
		
		return this.paneles[0].arreglar();
	}
}