package ventana;

public class ParcRoto extends EstadoPanel{

	@Override
	public boolean puedoArreglar(Panel panel) {
		panel.setEstado(new Sano());
		return true;
	}

	
}
