package ventana.panel;

public class Roto extends EstadoPanel{

	public boolean puedoArreglar(Panel panel) {
		panel.setEstado(new ParcRoto());
		return true;
	}
}
