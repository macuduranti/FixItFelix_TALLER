package ventana;

public class ConHojas extends Ventana{
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
	
}
