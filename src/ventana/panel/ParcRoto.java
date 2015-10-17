package ventana.panel;

public class ParcRoto extends EstadoPanel{

	@Override
	public boolean puedoArreglar(Panel panel) {
		panel.setEstado(new Sano());
		return true;
	}

	@Override
	public boolean puedoRomper(Panel panel) {
		panel.setEstado(new Roto());
		return true;
	}

	
}
