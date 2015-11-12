package ventana;

import juego.Direccion;

public class ConHojas extends Ventana {
	public boolean abierta;

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}

	@Override
	public boolean arreglarVentana() {
		return false;
	}

	@Override
	public boolean romperVentana() {
		return false;
	}

	@Override
	public boolean puedoPasarDesde(Direccion d) { // Se debe llamar con la prox
		if (this.isAbierta()) {
			if (d == Direccion.DERECHA)
				return false;
		}
		return true;
	}

	@Override
	public boolean puedoPasarHacia(Direccion d) {// Se debe llamar con la actual
		if (this.isAbierta()) {
			if (d == Direccion.IZQUIERDA)
				return false;
		}
		return true;
	}

	@Override
	public boolean puedeAparecerNicelander() {
		return false;
	}

}
