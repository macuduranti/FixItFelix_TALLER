package ventana;

public class Roto extends EstadoPanel{

	public boolean puedoArreglar(Panel panel) {
		panel.setEstado(new ParcRoto());
		return true;
	}
}
