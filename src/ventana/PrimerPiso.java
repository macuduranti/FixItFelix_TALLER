package ventana;

public class PrimerPiso extends Ventana {
	public boolean arreglarVentana() {// Devuelve boolean si pudo arreglar para
		// hacer la animacion o no, si devuelve
		// true podria incrementar una variable
		// que sea cantidad de veces arregladas
		// que compare con cantidad de veces a
		// arreglar (generada cuando ralph
		// rompe) para ver si se paso el nivel o
		// no
		if (!this.paneles[0].isSano()) {
			if (this.paneles[0].isParcRoto())
				return true; // y Cambiar a Sano
			else
				return true; // y Cambiar a ParcRoto

		} else {
			if (!this.paneles[1].isSano()) {
				if (this.paneles[1].isParcRoto())
					return true; // y Cambiar a Sano
				else
					return true; // y Cambiar a ParcRoto
			} else {
				if (!this.paneles[2].isSano()) {
					if (this.paneles[2].isParcRoto())
						return true; // y Cambiar a Sano
					else
						return true; // y Cambiar a ParcRoto
				} else {
					if (!this.paneles[3].isSano()) {
						if (this.paneles[3].isParcRoto())
							return true; // y Cambiar a Sano
						else
							return true; // y Cambiar a ParcRoto
					} else {
						if (!this.paneles[4].isSano()) {
							if (this.paneles[4].isParcRoto())
								return true; // y Cambiar a Sano
							else
								return true; // y Cambiar a ParcRoto

						} else {
							if (!this.paneles[5].isSano()) {
								if (this.paneles[5].isParcRoto())
									return true; // y Cambiar a Sano
								else
									return true; // y Cambiar a ParcRoto
							} else {
								if (!this.paneles[6].isSano()) {
									if (this.paneles[6].isParcRoto())
										return true; // y Cambiar a Sano
									else
										return true; // y Cambiar a ParcRoto
								} else {
									if (!this.paneles[7].isSano()) {
										if (this.paneles[7].isParcRoto())
											return true; // y Cambiar a Sano
										else
											return true; // y Cambiar a ParcRoto
									}
								}
							}
						}
					}
				}
			}
		}
		return false; // si los dos son sanos devuelve false, no hace animacion
	}
}
